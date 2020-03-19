package ua.kh.baklanov.db.queries;

public final class Queries {
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";

    public static final String INSERT_USER = "INSERT INTO " +
            "users (login, password, email, idRole, idStatus,bill) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id=?";

    public static final String UPDATE_USER_BY_LOGIN = "UPDATE users " +
            "SET login=?, password=?, email=?, idRole=?, idStatus=?, bill=? " +
            "WHERE login=?";

    public static final String DELETE_USER_BY_LOGIN = "DELETE FROM users WHERE login=?";

    public static final String GET_ALL_USERS = "SELECT * FROM users";

    public static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";

    public static final String GET_ALL_TV = "SELECT * FROM tv";

    public static final String GET_ANY_TARIFF_ALL_PC_TARIFFS =
            "SELECT t.id ,t.name,t.price,t.idService,t.durationInDays, " +
            "s.idPC, s.idInternet, " +
            "pc.numOfConnectedPC, " +
            "i.speed, i.technology " +
            "FROM services s " +
            "JOIN tariffs t ON s.id=t.idService " +
            "JOIN pc pc ON s.idPC=pc.id  " +
            "LEFT OUTER JOIN internet i ON s.idInternet=i.id;";

    public static final String GET_ANY_TARIFF_ALL_MOBILE_TARIFFS =
            "SELECT t.id ,t.name,t.price,t.idService, t.durationInDays," +
            "s.idMobile, s.idInternet, " +
            "mobile.numOfMinutesInside,mobile.numOfMinutesOutside,mobile.numOfSMS,mobile.numOfMbts," +
            "i.speed, i.technology " +
            "FROM services s " +
            "JOIN tariffs t ON s.id=t.idService " +
            "JOIN mobile mobile ON s.idMobile=mobile.id  " +
            "LEFT OUTER JOIN internet i ON s.idInternet=i.id";

    public static final String GET_ANY_TARIFF_ALL_TV_TARIFFS =  "SELECT t.id ,t.name,t.price,t.idService," +
            "t.durationInDays, " +
            "s.idTV, s.idInternet, " +
            "tv.type, tv.numOfChannels," +
            "i.speed, i.technology " +
            "FROM services s " +
            "JOIN tariffs t ON s.id=t.idService " +
            "JOIN tv tv ON s.idTV=tv.id  " +
            "LEFT OUTER JOIN internet i ON s.idInternet=i.id;";

    public static final String GET_SERVICE_BY_TARIFF_ID ="SELECT * FROM services s " +
            "JOIN tariffs t ON s.id=t.idService " +
            "WHERE t.id=?";

    public static final String GET_TV_BY_ID = "SELECT * FROM TV WHERE id=?";
    public static final String GET_PC_BY_ID  = "SELECT * FROM PC WHERE id=?";
    public static final String GET_TARIFF_BY_ID = "SELECT * FROM tariffs WHERE id=?";
    public static final String GET_INTERNET_BY_ID = "SELECT * FROM internet WHERE id=?";
    public static final String GET_MOBILE_BY_ID = "SELECT * FROM mobile WHERE id=?";

    private Queries() {
    }
}
