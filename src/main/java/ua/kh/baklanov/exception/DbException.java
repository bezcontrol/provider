package ua.kh.baklanov.exception;

/**
 * An exception that provides information on a database access error.
 * 
 * @author D.Kolesnikov
 * 
 */
public class DbException extends AppException {

	private static final long serialVersionUID = -3550446897536410392L;

	public DbException() {
		super();
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

}
