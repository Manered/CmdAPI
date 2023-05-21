package dev.manere.cmdapi.arguments;

/**
 * The ArgumentValidationException class represents an exception that occurs during argument validation.
 */
public class ArgumentValidationException extends RuntimeException {
    /**
     * Constructs a new ArgumentValidationException with the specified error message.
     *
     * @param message the error message
     */
    public ArgumentValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new ArgumentValidationException with the specified error message and cause.
     *
     * @param message the error message
     * @param cause   the cause of the exception
     */
    public ArgumentValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
