package dev.manere.cmdapi.exception;

/**
 * Base exception class for command-related exceptions.
 */
public class CommandException extends RuntimeException {
    /**
     * Constructs a CommandException with the specified error message.
     *
     * @param message The error message.
     */
    public CommandException(String message) {
        super(message);
    }

    /**
     * Constructs a CommandException with the specified error message and cause.
     *
     * @param message The error message.
     * @param cause   The cause of the exception.
     */
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
