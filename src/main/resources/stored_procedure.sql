use internet_provider;
DELIMITER //
DROP PROCEDURE IF EXISTS UpdateBalance;
CREATE PROCEDURE UpdateBalance()
BEGIN

    DECLARE loop0_eof BOOLEAN DEFAULT FALSE;
    DECLARE userId INT;
    DECLARE tariffId INT;
    DECLARE contractId INT;
    DECLARE tariffPrice INT;
    DECLARE bill DECIMAL(10,2) DEFAULT 0;
    DECLARE statusBlockedId INT;
    DECLARE statusNormalId INT;
    DECLARE currentStatus INT;
    DECLARE statusFullBlocked INT;
    DECLARE expirationDate DATE;
    DECLARE currentContractState INT;
    DECLARE registeredContractState INT;
    DECLARE cur0 CURSOR FOR SELECT c.id FROM contracts c;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET loop0_eof = TRUE;

    OPEN cur0;

    loop0: LOOP
        FETCH cur0 INTO contractId;
        IF loop0_eof THEN
            LEAVE loop0;
        END IF;
        set userId = (SELECT u.id FROM users u WHERE u.id IN (SELECT  c.idUser FROM contracts c WHERE c.id=contractId));
        set currentStatus = (SELECT u.idStatus FROM users u WHERE u.id IN (SELECT  c.idUser FROM contracts c WHERE c.id=contractId));
        set tariffId = (SELECT t.id FROM tariffs t JOIN contracts c ON c.idTariff=t.id WHERE c.id=contractId);
        set tariffPrice = (SELECT t.price FROM tariffs t JOIN contracts c ON c.idTariff=t.id WHERE c.id=contractId);
        set bill = (SELECT u.bill FROM users u WHERE u.id IN (SELECT  c.idUser FROM contracts c WHERE c.id=contractId));
        set statusBlockedId=(SELECT s.id FROM statuses s WHERE s.name = 'blocked');
        set statusNormalId=(SELECT s.id FROM statuses s WHERE s.name = 'registered');
        set statusFullBlocked=(SELECT s.id FROM statuses s WHERE s.name = 'blockedByAdmin');
        set expirationDate=(SELECT contractExpirationDate FROM contracts WHERE id=contractId);
        set currentContractState=(SELECT c.idContractState FROM contracts c WHERE c.id=contractId);
        set registeredContractState=(SELECT c.id FROM contractstates c WHERE c.name='registered');

        if(currentStatus!=statusFullBlocked) then
            if(currentContractState=registeredContractState) then
                if(expirationDate<NOW() ) then
                    if (bill >= tariffPrice ) then
                        UPDATE users u JOIN contracts c ON u.id=c.idUser JOIN tariffs t ON t.id=c.idTariff
                        SET u.bill = u.bill-t.price
                        WHERE c.idTariff=tariffId;

                        UPDATE contracts c JOIN tariffs t ON t.id=c.idTariff JOIN users u ON u.id=c.idUser JOIN statuses s ON u.idStatus=s.id
                        SET c.contractExpirationDate = DATE_ADD( c.contractExpirationDate, INTERVAL t.durationInDays DAY)
                        WHERE c.idTariff=tariffId;
                    else
                        UPDATE users u JOIN statuses s ON u.idStatus=s.id
                        SET u.idStatus =  statusBlockedId
                        WHERE u.id=userId;
                    end if;
                else
                    UPDATE users u JOIN statuses s ON u.idStatus=s.id
                    SET u.idStatus = statusNormalId
                    WHERE u.id=userId;
                end if;
            end if;
        end if;
    END LOOP loop0;
    CLOSE cur0;
END
//
DELIMITER ;