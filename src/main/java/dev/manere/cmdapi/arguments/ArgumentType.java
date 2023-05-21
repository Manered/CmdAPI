package dev.manere.cmdapi.arguments;

/**
 * The ArgumentType interface represents a type of command argument that can be parsed from a string input.
 *
 * @param <T> the type of the argument
 */
public interface ArgumentType<T> {
    /**
     * Parses the argument from the given input string.
     *
     * @param input the input string to parse the argument from
     * @return the parsed argument
     * @throws ArgumentValidationException if the argument validation fails
     */
    T parse(String input) throws ArgumentValidationException;
}
