DROP SCHEMA IF EXISTS `internet_provider`;
CREATE SCHEMA `internet_provider` ;
USE `internet_provider`;

CREATE TABLE `roles` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(45) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE (`id`),
                         UNIQUE (`name`));

CREATE TABLE `statuses` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(45) NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE (`id`),
                            UNIQUE (`name`));

CREATE TABLE `internet` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `speed` INT NOT NULL,
                            `technology` VARCHAR(45) NOT NULL,
                            PRIMARY KEY (`id`));

CREATE TABLE `users` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `login` VARCHAR(45) NOT NULL,
                         `password` VARCHAR(45) NOT NULL,
                         `email` VARCHAR(45),
                         `idRole` INT NOT NULL,
                         `idStatus` INT NOT NULL,
                         `bill` DOUBLE NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE (`id`),
                         UNIQUE (`login`),
                         UNIQUE (`email`),
                         CONSTRAINT `fk_user_role`
                             FOREIGN KEY (`idRole`)
                                 REFERENCES `roles` (`id`)
                                 ON DELETE CASCADE
                                 ON UPDATE CASCADE,
                         CONSTRAINT `fk_user_status`
                             FOREIGN KEY (`idStatus`)
                                 REFERENCES `statuses` (`id`)
                                 ON DELETE CASCADE
                                 ON UPDATE CASCADE);

CREATE TABLE `pc` (
                      `id` INT NOT NULL AUTO_INCREMENT,
                      `numOfConnectedPC` INT NOT NULL,
                      PRIMARY KEY (`id`));


CREATE TABLE `tv` (
                      `id` INT NOT NULL AUTO_INCREMENT,
                      `type` VARCHAR(45) NOT NULL,
                      `numOfChannels` INT NOT NULL,
                      PRIMARY KEY (`id`)
);

CREATE TABLE `mobile` (
                          `id` INT NOT NULL AUTO_INCREMENT,
                          `numOfMinutesInside` INT NOT NULL,
                          `numOfMinutesOutside` INT NOT NULL,
                          `numOfSMS` INT NOT NULL,
                          `numOfMbts` INT NOT NULL,
                          PRIMARY KEY (`id`));

CREATE TABLE `services` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `idPC` INT,
                            `idTV` INT,
                            `idMobile` INT,
                            `idInternet` INT,
                             `description` VARCHAR(45) NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE  (`id`),
                            CONSTRAINT `fk_service_pc`
                                FOREIGN KEY (`idPC`)
                                    REFERENCES `pc` (`id`)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE,
                            CONSTRAINT `fk_service_tv`
                                FOREIGN KEY (`idTV`)
                                    REFERENCES `tv` (`id`)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE,
                            CONSTRAINT `fk_service_mobile`
                                FOREIGN KEY (`idMobile`)
                                    REFERENCES `mobile` (`id`)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE,
                            CONSTRAINT `fk_service_internet`
                                FOREIGN KEY (`idInternet`)
                                    REFERENCES `internet` (`id`)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE
);




DELIMITER $$

CREATE DEFINER=`user`@`localhost` TRIGGER `services_BEFORE_INSERT` BEFORE INSERT ON `services` FOR EACH ROW BEGIN

IF exists (SELECT 1 FROM `services`
   WHERE  idTV<=>NEW.idTV and idPC<=>NEW.idPC and idMobile<=>NEW.idMobile and idInternet<=>NEW.idInternet
  )
  THEN
        signal sqlstate '45000' set message_text = 'MyTriggerError: Trying to insert duplicate!';
  END IF;

END$$

DELIMITER ;


CREATE TABLE `tariffs` (
                           `id` INT NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(45) NOT NULL,
                           `price` INT NOT NULL,
                           `idService` INT NOT NULL,
                           `durationInDays` INT NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE (`id`),
                           CONSTRAINT `fk_tarif_service`
                               FOREIGN KEY (`idService`)
                                   REFERENCES `services` (`id`)
                                   ON DELETE CASCADE
                                   ON UPDATE CASCADE);

CREATE TABLE `contracts` (
                             `id` INT NOT NULL AUTO_INCREMENT,
                             `idUser` INT NOT NULL,
                             `idTariff` INT NOT NULL,
                             `idStatus` INT NOT NULL,
                             `contractConclusionDate` DATETIME NOT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE (`id`),
                             CONSTRAINT `fk_contract_user`
                                 FOREIGN KEY (`idUser`)
                                     REFERENCES `users` (`id`)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE,
                             CONSTRAINT `fk_contract_tariff`
                                 FOREIGN KEY (`idTariff`)
                                     REFERENCES `tariffs` (`id`)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE);



INSERT INTO `roles` (`name`) VALUES ('admin');
INSERT INTO `roles` (`name`) VALUES ('client');
INSERT INTO `statuses` (`name`) VALUES ('waiting');
INSERT INTO `statuses` (`name`) VALUES ('registered');
INSERT INTO `statuses` (`name`) VALUES ('blocked');
INSERT INTO `statuses` (`name`) VALUES ('missed');
INSERT INTO `users` (`login`, `password`,`email`, `idRole`, `idStatus`, `bill`) VALUES ('admin','adminpass','user@gmail.com', '1','2','100.0');
INSERT INTO `users` (`login`, `password`,`email`, `idRole`,`idStatus`, `bill`) VALUES ('client','clientpass','user2@gmail.com', '2','2','200.0');
INSERT INTO `internet` (id, speed, technology) VALUES (1, 520, '3G');
INSERT INTO `internet` (id, speed, technology) VALUES (2, 640, '4G');
INSERT INTO `internet` (id, speed, technology) VALUES (3, 800, '5G');
INSERT INTO `internet` (id, speed, technology) VALUES (4, 1000, '4G');
INSERT INTO `pc` (`numOfConnectedPC`) VALUES ('1');
INSERT INTO `pc` (`numOfConnectedPC`) VALUES ('10');
INSERT INTO `tv` (`type`,`numOfChannels`) VALUES ('Analog','100');
INSERT INTO `tv` (`type`,`numOfChannels`) VALUES ('IP-TV','150');
INSERT INTO `tv` (`type`,`numOfChannels`) VALUES ('Smart-TV','200');
INSERT INTO `mobile` (`numOfMinutesInside`,`numOfMinutesOutside`,`numOfSMS`,`numOfMbts`) VALUES ('100','20','50','7000');
INSERT INTO `mobile` (`numOfMinutesInside`,`numOfMinutesOutside`,`numOfSMS`,`numOfMbts`) VALUES ('50','100','25','8000');
INSERT INTO `mobile` (`numOfMinutesInside`,`numOfMinutesOutside`,`numOfSMS`,`numOfMbts`) VALUES ('300','100','50','0');
INSERT INTO `mobile` (`numOfMinutesInside`,`numOfMinutesOutside`,`numOfSMS`,`numOfMbts`) VALUES ('250','100','25','2000');
INSERT INTO services (id,idTV,idInternet,description) VALUES (1,2,2,'ip-tv with simple internet');
INSERT INTO services (id,idTV,idInternet,description) VALUES (2,3,3, 'smart-tv with great internet');
INSERT INTO services (id,idTV,description) VALUES (3,1, 'analog without internet');
INSERT INTO services (id,idTV,idInternet,description) VALUES (4,3,4, 'smart-tv with the best internet');
INSERT INTO services (id,idPC,idInternet,description) VALUES (5,1,3,'5G internet for single pc');
INSERT INTO services (id,idPC,idInternet,description) VALUES (6,2,4, '4G internet for N pc');
INSERT INTO services (id,idMobile,description) VALUES (7,3,'mobile without internet');
INSERT INTO services (id,idMobile,idInternet,description) VALUES (8,2,2,'8Gb 4G internet');
INSERT INTO services (id,idMobile,idInternet,description) VALUES (9,2,3, '8Gb 5G internet');
INSERT INTO services (id,idMobile,idInternet,description) VALUES (10,1,2, '7Gb 4G slow internet');
INSERT INTO services (id,idMobile,idInternet,description) VALUES (11,1,4,'7Gb 4G fast internet');
INSERT INTO services (id,idMobile,idInternet,description) VALUES (12,4,1,'2Gb 3G internet');
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (1,'Analog TV', 100, 3, 30);
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (2,'IP-TV', 150, 1, 30);
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (3,'Smart-TV', 250, 2, 28);
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (4,'Smart-TV', 250, 4, 28);
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (5,'Usual pc', 125, 5, 30);
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (7,'Pro pc', 175, 6,'28');
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (6,'Usual mobile', 150, 9, 30);
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (8,'Mobile for speak', 125, 7, 28);
INSERT INTO tariffs (id,name, price, idService,durationInDays) VALUES (9,'Pro mobile', 125, 11, 28);

