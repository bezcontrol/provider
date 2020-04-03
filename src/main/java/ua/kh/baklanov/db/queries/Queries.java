package ua.kh.baklanov.db.queries;

public final class Queries {

    public static final String GET_USER_BY_LOGIN = "SELECT id AS 'idUser', login, password, " +
            "email, idRole, idStatus, bill " +
            "FROM users WHERE login=?";

    public static final String INSERT_USER = "INSERT INTO " +
            "users (login, password, email, idRole, idStatus,bill) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    public static final String GET_USER_BY_ID = "SELECT id AS 'idUser', login, password, email, " +
            "idRole, idStatus, bill " +
            "FROM users WHERE id=?";

    public static final String UPDATE_USER_BY_LOGIN = "UPDATE users " +
            "SET login=?, email=?, idRole=?, idStatus=?, bill=? " +
            "WHERE login=?";

    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";

    public static final String GET_ALL_USERS = "SELECT id AS 'idUser', login, password, email, " +
            "idRole, idStatus, bill " +
            "FROM users;";

    public static final String GET_USER_BY_EMAIL = "SELECT id AS 'idUser', login, password, email, " +
            "idRole, idStatus, bill " +
            "FROM users WHERE email=?";

    public static final String GET_ALL_TV = "SELECT id AS 'idTV', type, numOfChannels FROM tv";

    public static final String GET_ANY_TARIFF_ALL_PC_TARIFFS =
            "SELECT t.id AS 'idTariff' ,t.name AS 'tariffName',t.price,t.idService,t.durationInDays, " +
            "s.idPC, s.idInternet, " +
            "pc.numOfConnectedPC, " +
            "i.speed, i.technology " +
            "FROM services s " +
            "JOIN tariffs t ON s.id=t.idService " +
            "JOIN pc pc ON s.idPC=pc.id  " +
            "LEFT OUTER JOIN internet i ON s.idInternet=i.id;";

    public static final String GET_ANY_TARIFF_ALL_MOBILE_TARIFFS =
            "SELECT t.id AS 'idTariff',t.name AS 'tariffName',t.price,t.idService, t.durationInDays," +
            "s.idMobile, s.idInternet, " +
            "mobile.numOfMinutesInside,mobile.numOfMinutesOutside,mobile.numOfSMS,mobile.numOfMbts," +
            "i.speed, i.technology " +
            "FROM services s " +
            "JOIN tariffs t ON s.id=t.idService " +
            "JOIN mobile mobile ON s.idMobile=mobile.id  " +
            "LEFT OUTER JOIN internet i ON s.idInternet=i.id";

    public static final String GET_ANY_TARIFF_ALL_TV_TARIFFS =  "SELECT t.id AS 'idTariff' ,t.name AS 'tariffName'," +
            "t.price, t.idService, t.durationInDays, " +
            "s.idTV, s.idInternet, " +
            "tv.type, tv.numOfChannels," +
            "i.speed, i.technology " +
            "FROM services s " +
            "JOIN tariffs t ON s.id=t.idService " +
            "JOIN tv tv ON s.idTV=tv.id  " +
            "LEFT OUTER JOIN internet i ON s.idInternet=i.id;";

    public static final String GET_SERVICE_BY_TARIFF_ID ="SELECT s.id AS 'idService',s.idPC,s.idTV, s.idMobile, " +
            "s.idInternet, s.description, t.id AS 'idTariff', t.name AS 'tariffName', t.durationInDays " +
            "FROM services s JOIN tariffs t ON s.id=t.idService WHERE t.id=?";

    public static final String GET_TV_BY_ID = "SELECT id AS 'idTV', type, numOfChannels  FROM TV WHERE id=?";
    public static final String GET_PC_BY_ID  = "SELECT id AS 'idPC', numOfConnectedPC FROM PC WHERE id=?";
    public static final String GET_TARIFF_BY_ID = "SELECT id AS 'idTariff', name AS 'tariffName', idService, " +
            "price, durationInDays  FROM tariffs WHERE id=?";
    public static final String GET_INTERNET_BY_ID = "SELECT id AS 'idInternet', speed, technology " +
            "FROM internet WHERE id=?";
    public static final String GET_MOBILE_BY_ID = "SELECT id AS 'idMobile', numOfMinutesInside, numOfMinutesOutside, " +
            "numOfSMS, numOfMbts FROM mobile WHERE id=?";
    public static final String GET_ALL_INTERNET = "SELECT id AS 'idInternet', speed, technology FROM internet";
    public static final String GET_PC_INTERNET = "SELECT i.id AS 'idInternet', i.speed, i.technology FROM services s " +
            "JOIN internet i ON s.idInternet=i.id where idPC is not null and s.idPC=? GROUP BY i.id";
    public static final String GET_TV_INTERNET = "SELECT i.id AS 'idInternet', i.speed, i.technology FROM services s " +
            "JOIN internet i ON s.idInternet=i.id where idTV is not null and s.idTV=? GROUP BY i.id";
    public static final String GET_MOBILE_INTERNET = "SELECT i.id AS 'idInternet', i.speed, i.technology " +
            "FROM services s JOIN internet i ON s.idInternet=i.id where idMobile is not null and s.idMobile=? " +
            "GROUP BY i.id";

    public static final String GET_ANY_SERVICES_OF_PC = "SELECT s.id AS 'idService', s.idPC, s.idInternet, " +
            "s.description, pc.numOfConnectedPC, i.speed, i.technology " +
            "FROM services s JOIN pc pc ON pc.id=s.idPC join internet i ON s.idInternet=i.id where idPC = ?";
    public static final String GET_ANY_SERVICES_OF_TV =  "SELECT s.id AS 'idService', s.idTV, " +
            "s.idInternet, s.description, tv.type, tv.numOfChannels, i.speed, i.technology FROM services s " +
            "JOIN tv tv ON tv.id=s.idTV join internet i ON s.idInternet=i.id where s.idTV =?";
    public static final String GET_ANY_SERVICES_OF_MOBILE =  "SELECT s.id AS 'idService', s.idMobile, s.idInternet, " +
            "s.description, m.numOfMinutesInside, m.numOfMinutesOutside, m.numOfSMS, m.numOfMbts, " +
            "i.speed, i.technology FROM services s " +
            "JOIN mobile m ON m.id=s.idMobile join internet i ON s.idInternet=i.id where s.idMobile =?";
    public static final String UPDATE_TARIFF = "UPDATE tariffs SET " +
            "name=?, price=?, idService=?, durationInDays=? WHERE id=?";
    public static final String GET_ALL_ANY_SERVICES = "SELECT s.id AS 'idService', s.idPC, s.idTV, s.idMobile, " +
            "s.idInternet, s.description, i.speed, i.technology, pc.numOfConnectedPC, " +
            "tv.type, tv.numOfChannels, m.numOfMinutesInside, m.numOfMinutesOutside, m.numOfSMS, m.numOfMbts " +
            "FROM services s " +
            "LEFT OUTER JOIN internet i ON s.idInternet=i.id " +
            "LEFT OUTER JOIN pc pc ON s.idPC = pc.id " +
            "LEFT OUTER JOIN tv tv ON s.idTV=tv.id " +
            "LEFT OUTER JOIN mobile m ON s.idMobile=m.id;";

    public static final String INSERT_TARIFF = "INSERT INTO " +
            "tariffs (name, price, idService, durationInDays) " +
            "VALUES (?, ?, ?, ?)";
    public static final String DELETE_TARIFF_BY_ID =  "DELETE FROM tariffs WHERE id=?";

    public static final String GET_ALL_USERS_INFO ="SELECT u.id AS 'idUser', u.login, u.password, u.email, u.idRole, " +
            "u.idStatus, u.bill, r.name AS 'roleName', s.name AS 'statusName' " +
            "FROM users u " +
            "JOIN roles r ON u.idRole=r.id " +
            "JOIN statuses s ON u.idStatus=s.id";

    public static final String GET_USER_BEAN_BY_LOGIN="SELECT u.id AS 'idUser', u.login, u.password, u.email, " +
            "u.idRole, u.idStatus, u.bill, r.name AS 'roleName', s.name AS 'statusName' " +
            "FROM users u " +
            "JOIN roles r ON u.idRole=r.id " +
            "JOIN statuses s ON u.idStatus=s.id " +
            "WHERE u.login=?";

    public static final String GET_USER_BEAN_BY_EMAIL = "SELECT u.id AS 'idUser', u.login, u.password, u.email, " +
            "u.idRole, u.idStatus, u.bill, r.name AS 'roleName', s.name AS 'statusName' " +
            "FROM users u " +
            "JOIN roles r ON u.idRole=r.id " +
            "JOIN statuses s ON u.idStatus=s.id " +
            "WHERE u.email=?";

    public static final String GET_ROLE_BY_NAME = "SELECT id as 'idRole', name as 'roleName' FROM roles WHERE name=?";

    public static final String GET_STATUS_BY_NAME = "SELECT id AS 'idStatus', name as 'statusName' " +
            "FROM statuses WHERE name=?";
    public static final String GET_ALL_ROLES = "SELECT id as 'idRole', name as 'roleName' FROM roles";

    public static final String GET_ALL_STATUSES = "SELECT id AS 'idStatus', name as 'statusName' FROM statuses";
    public static final String INSERT_CONTRACT = "INSERT INTO " +
            "contracts (idUser, idTariff, idContractState, contractConclusionDate, contractExpirationDate) " +
            "VALUES (?, ?, ? , ?, ?)";
    public static final String GET_CONTRACT_STATE_BY_NAME = "SELECT id AS 'idContractState', " +
            "name as 'contractStateName' " +
            "FROM contractState WHERE name=?";

    public static final String GET_ALL_USER_CONTRACTS = "SELECT c.id AS 'idContract', c.idContractState, " +
            "c.contractConclusionDate, c.contractExpirationDate, u.id AS 'idUser', u.login, u.password, u.email, " +
            "u.idRole, u.bill, s.id AS 'idStatus', s.name AS 'statusName', t.id AS 'idTariff', " +
            "t.name AS 'tariffName', t.price, t.idService, t.durationInDays, state.id AS 'idContractState', " +
            "state.name AS 'contractStateName', r.name AS 'roleName', s.name AS 'statusName' " +
            "FROM contracts c " +
            "JOIN users u ON u.id=c.idUser " +
            "JOIN statuses s ON u.idStatus=s.id " +
            "JOIN tariffs t ON c.idTariff=t.id " +
            "JOIN contractstate state ON c.idContractState=state.id " +
            "JOIN roles r ON u.idRole=r.id;";
    public static final String GET_ALL_CONTRACT_STATES = "SELECT id AS 'idContractState', " +
            "name as 'contractStateName' " +
            "FROM contractState";
    public static final String UPDATE_CONTRACT = "UPDATE contracts " +
            "SET idUser=?, idTariff=?, idContractState=?, contractConclusionDate=?, contractExpirationDate=? " +
            "WHERE id=?";

    private Queries() {
    }
}
