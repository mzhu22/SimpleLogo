package errorsAndExceptions;

/**
 * This class is to represent the error that should be thrown if something goes wrong.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 * @author Robert Duvall
 */
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
