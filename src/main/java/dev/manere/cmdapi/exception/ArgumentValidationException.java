package dev.manere.cmdapi.exception;

public class ArgumentValidationException extends CommandException {
    public ArgumentValidationException(String message) {
        super(message);
    }

    public ArgumentValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
