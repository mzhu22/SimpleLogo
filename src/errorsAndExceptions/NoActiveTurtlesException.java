package errorsAndExceptions;

public class NoActiveTurtlesException extends RuntimeException{
    // for serialization
    private static final long serialVersionUID = 1L;

    /**
     * Create an exception based on an issue in our code.
     */
    public NoActiveTurtlesException (String message) {
        super(message);
    }

    /**
     * Create an exception based on a caught exception.
     */
    public NoActiveTurtlesException (Throwable exception) {
        super(exception);
    }
    
    /**
     * Create an exception based on a caught exception with a different message.
     */
    public NoActiveTurtlesException (String message, Throwable cause) {
        super(message, cause);
    }

}
