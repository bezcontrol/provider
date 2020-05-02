package ua.kh.baklanov.exception;

/**
 * An exception that provides information on an application error.
 *
 * @author Aleksei Baklanov
 */
public class AppException extends Exception {

    public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

}
