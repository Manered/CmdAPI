package dev.manere.cmdapi.builders;

import dev.manere.cmdapi.arguments.ArgumentType;

/**
 * The ArgumentBuilder class is responsible for building arguments with specific properties.
 *
 * @param <T> the type of the argument
 */
public class ArgumentBuilder<T> {
    private final ArgumentType<T> argumentType;
    private String name;
    private boolean optional;
    private T defaultValue;

    /**
     * Constructs a new ArgumentBuilder instance with the specified argument type.
     *
     * @param argumentType the argument type
     */
    public ArgumentBuilder(ArgumentType<T> argumentType) {
        this.argumentType = argumentType;
        this.name = "";
        this.optional = false;
        this.defaultValue = null;
    }

    /**
     * Sets the name of the argument.
     *
     * @param name the name of the argument
     * @return the ArgumentBuilder instance
     */
    public ArgumentBuilder<T> name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Marks the argument as optional.
     *
     * @return the ArgumentBuilder instance
     */
    public ArgumentBuilder<T> optional() {
        this.optional = true;
        return this;
    }

    /**
     * Sets the default value for the argument.
     *
     * @param defaultValue the default value for the argument
     * @return the ArgumentBuilder instance
     */
    public ArgumentBuilder<T> defaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    /**
     * Builds the argument with the specified properties.
     *
     * @return the built ArgumentType instance
     */
    public ArgumentType<T> build() {
        return (input) -> {
            if (input.isEmpty() && optional) {
                return defaultValue;
            }
            return argumentType.parse(input);
        };
    }
}
