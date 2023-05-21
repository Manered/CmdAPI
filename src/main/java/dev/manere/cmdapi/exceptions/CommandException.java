package dev.manere.cmdapi.exceptions;

/**
 * The CommandException class represents an exception that occurs during command execution.
 */
public class CommandException extends RuntimeException {
    /**
     * Constructs a new CommandException instance with the specified error message.
     *
     * @param message the error message
     */
    public CommandException(String message) {
        super(message);
    }

    /**
     * Constructs a new CommandException instance with the specified error message and cause.
     *
     * @param message the error message
     * @param cause   the cause of the exception
     */
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
