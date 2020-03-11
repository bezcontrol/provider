DROP SCHEMA IF EXISTS `internet_provider`;
CREATE SCHEMA `internet_provider` ;
USE `internet_provider`;

 CREATE TABLE `roles` (
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
  `email` VARCHAR(45) NOT NULL,
  `idRole` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`id`),
  UNIQUE (`login`),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`idRole`)
    REFERENCES `roles` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

    CREATE TABLE `pc` (
  `id` INT NOT NULL AUTO_INCREMENT,
`numOfConnectedPC` INT NOT NULL,
  PRIMARY KEY (`id`));


    CREATE TABLE `tv` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  );

    CREATE TABLE `mobile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numOfConnectedPhones` INT NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `services` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idpc` INT,
  `idtv` INT,
  `idmobile` INT,
`idInternet` INT,
  PRIMARY KEY (`id`),
  UNIQUE  (`id`),
  UNIQUE (`idPC`),
  UNIQUE (`idTV`),
  UNIQUE (`idMobile`),
CONSTRAINT `fk_service_pc`
  FOREIGN KEY (`idpc`)
  REFERENCES `pc` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
 CONSTRAINT `fk_service_tv`
  FOREIGN KEY (`idtv`)
  REFERENCES `tv` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT `fk_service_mobile`
  FOREIGN KEY (`idmobile`)
  REFERENCES `mobile` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
   CONSTRAINT `fk_service_internet`
    FOREIGN KEY (`idInternet`)
    REFERENCES `internet` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

      CREATE TABLE `statuses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`id`),
  UNIQUE (`name`));

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
  `bill` DOUBLE NOT NULL,
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
    ON UPDATE CASCADE,
CONSTRAINT `fk_status_contract`
    FOREIGN KEY (`idStatus`)
    REFERENCES `statuses` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);



INSERT INTO `roles` (`id`, `name`) VALUES ('1', 'Admin');
INSERT INTO `roles` (`id`, `name`) VALUES ('2', 'Customer');
INSERT INTO `users` (`id`, `login`, `password`,`email`, `idRole`) VALUES ('1', 'login1','pass1','user@gmail.com', '1');
INSERT INTO `users` (`id`, `login`, `password`,`email`, `idRole`) VALUES ('2', 'login2','pass2','user2@gmail.com', '2');
INSERT INTO `internet` (`id`, `speed`, `technology`) VALUES ('1', '640', '4G');
INSERT INTO `internet` (`id`, `speed`, `technology`) VALUES ('2', '800', '5G');
INSERT INTO `internet` (`id`, `speed`, `technology`) VALUES ('3', '1000', '4G');
INSERT INTO `pc` (`id`,`numOfConnectedPC`) VALUES ('1','1');
INSERT INTO `pc` (`id`,`numOfConnectedPC`) VALUES ('2','10');
INSERT INTO `tv` (`id`, `type`) VALUES ('1', 'Analog');
INSERT INTO `tv` (`id`, `type`) VALUES ('2', 'IP-TV');
INSERT INTO `mobile` (`id`, `numOfConnectedPhones`) VALUES ('1','1');
INSERT INTO `mobile` (`id`, `numOfConnectedPhones`) VALUES ('2','5');
INSERT INTO `services` (`id`, `idtv`,`idInternet`) VALUES ('1', '1', '1');
INSERT INTO `services` (`id`, `idtv`) VALUES ('2', '2');
INSERT INTO `services` (`id`, `idpc`,`idInternet`) VALUES ('3', '1', '2');
INSERT INTO `services` (`id`, `idmobile`,`idInternet`) VALUES ('4', '2','1');
INSERT INTO `services` (`id`, `idpc`,`idInternet`) VALUES ('5', '2','2');
INSERT INTO `services` (`id`, `idmobile`) VALUES ('6', '1');
INSERT INTO `statuses` (`id`, `name`) VALUES ('1', 'normal');
INSERT INTO `statuses` (`id`, `name`) VALUES ('2', 'blocked');
INSERT INTO `statuses` (`id`, `name`) VALUES ('3', 'waiting');
INSERT INTO `tariffs` (`id`, `name`, `price`, `idService`,`durationInDays`) VALUES ('1', 'Analog TV', '100', '1','30');
INSERT INTO `tariffs` (`id`, `name`, `price`, `idService`,`durationInDays`) VALUES ('2', 'IP-TV', '150', '2','30');
INSERT INTO `tariffs` (`id`, `name`, `price`, `idService`,`durationInDays`) VALUES ('3', 'PC with 4G internet', '125', '5','30');
INSERT INTO `tariffs` (`id`, `name`, `price`, `idService`,`durationInDays`) VALUES ('4', 'Mobile with 5G internet', '150', '4','30');
INSERT INTO `tariffs` (`id`, `name`, `price`, `idService`,`durationInDays`) VALUES ('5', 'PC with 5G internet', '175', '3','28');
INSERT INTO `tariffs` (`id`, `name`, `price`, `idService`,`durationInDays`) VALUES ('6', 'Mobile with 4G internet', '125', '6','28');
