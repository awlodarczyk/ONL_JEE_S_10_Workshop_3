package pl.coderslab.exception;

public class DaoException extends RuntimeException {

    public DaoException(String msg, Exception cause) {
        super(msg, cause);
    }
}
