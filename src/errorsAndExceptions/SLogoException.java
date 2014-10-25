package errorsAndExceptions;

public class SLogoException extends RuntimeException {

	// for serialization
    private static final long serialVersionUID = 1L;

    /**
     * Create an exception based on an issue in our code.
     */
    public SLogoException (String message) {
        super(message);
    }

    /**
     * Create an exception based on a caught exception.
     */
    public SLogoException (Throwable exception) {
        super(exception);
    }
    
    /**
     * Create an exception based on a caught exception with a different message.
     */
    public SLogoException (String message, Throwable cause) {
        super(message, cause);
    }

}
