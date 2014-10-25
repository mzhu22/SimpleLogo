package errorsAndExceptions;

public class InvalidImageIndexException extends RuntimeException{

	// for serialization
    private static final long serialVersionUID = 1L;

    /**
     * Create an exception based on an issue in our code.
     */
    public InvalidImageIndexException (String message) {
        super(message);
    }

    /**
     * Create an exception based on a caught exception.
     */
    public InvalidImageIndexException (Throwable exception) {
        super(exception);
    }
    
    /**
     * Create an exception based on a caught exception with a different message.
     */
    public InvalidImageIndexException (String message, Throwable cause) {
        super(message, cause);
    }

}
