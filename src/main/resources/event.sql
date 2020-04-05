DROP EVENT IF EXISTS event_update_balance;
CREATE EVENT event_update_balance
    ON SCHEDULE EVERY 1 second
    DO
    CALL UpdateBalance();