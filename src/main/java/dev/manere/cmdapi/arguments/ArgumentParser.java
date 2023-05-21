package dev.manere.cmdapi.arguments;

import java.util.HashMap;
import java.util.Map;

/**
 * The ArgumentParser class is responsible for parsing command arguments based on registered argument types.
 */
public class ArgumentParser {
    private final Map<Class<?>, ArgumentType<?>> argumentTypes;

    /**
     * Constructs a new ArgumentParser instance.
     */
    public ArgumentParser() {
        argumentTypes = new HashMap<>();
    }

    /**
     * Registers a new argument type.
     *
     * @param argumentClass the class representing the argument type
     * @param argumentType  the argument type implementation
     * @param <T>           the argument type
     */
    public <T> void registerArgumentType(Class<T> argumentClass, ArgumentType<T> argumentType) {
        argumentTypes.put(argumentClass, argumentType);
    }

    /**
     * Parses an argument of the specified class from the given input.
     *
     * @param argumentClass the class of the argument to parse
     * @param input         the input string to parse the argument from
     * @param <T>           the argument type
     * @return the parsed argument
     * @throws ArgumentValidationException if the argument validation fails
     */
    public <T> T parseArgument(Class<T> argumentClass, String input) throws ArgumentValidationException {
        ArgumentType<?> argumentType = argumentTypes.get(argumentClass);
        if (argumentType == null) {
            throw new IllegalArgumentException("No argument type registered for class: " + argumentClass.getSimpleName());
        }
        return argumentClass.cast(argumentType.parse(input));
    }
}
