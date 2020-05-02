package ua.kh.baklanov.exception;

/**
 * An exception that provides information on a database access error.
 *
 * @author Aleksei Baklanov
 */
public class DbException extends AppException {

    public DbException() {
        super();
    }

    public DbException(String message, Throwable cause) {
        super(message, cause);
    }

}
