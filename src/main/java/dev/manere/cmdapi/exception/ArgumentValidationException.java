package dev.manere.cmdapi.exception;

/**
 * Exception thrown when an argument fails validation during command execution.
 */
public class ArgumentValidationException extends CommandException {
    /**
     * Constructs an ArgumentValidationException with the specified error message.
     *
     * @param message The error message.
     */
    public ArgumentValidationException(String message) {
        super(message);
    }

    /**
     * Constructs an ArgumentValidationException with the specified error message and cause.
     *
     * @param message The error message.
     * @param cause   The cause of the exception.
     */
    public ArgumentValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
