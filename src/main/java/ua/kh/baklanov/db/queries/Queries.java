package ua.kh.baklanov.db.queries;

public class Queries {
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";

    public static final String INSERT_USER = "INSERT INTO users (login, password, email, idRole, idStatus) VALUES (?, ?, ?, ?,?)";

    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id=?";

    public static final String UPDATE_USER_BY_LOGIN = "UPDATE users SET login=?, password=?, email=?, idRole=?, idStatus=? WHERE login=?";

    public static final String DELETE_USER_BY_LOGIN = "DELETE FROM users WHERE login=?";

    public static final String GET_ALL_USERS = "SELECT * FROM users";

    public static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";

    private Queries() {

    }
}
