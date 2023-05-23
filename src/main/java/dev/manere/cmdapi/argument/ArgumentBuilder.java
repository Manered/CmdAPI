package dev.manere.cmdapi.argument;

import org.bukkit.command.CommandSender;

import java.util.function.Predicate;

/**
 * Builder class for creating instances of the {@link Argument} class.
 *
 * @param <T> The type of the argument value.
 */
public class ArgumentBuilder<T> {
    private final String name;
    private String description = "";
    private Predicate<CommandSender> permissionCheck = sender -> true;
    private Predicate<String> validationRule = argument -> true;

    /**
     * Constructs an ArgumentBuilder with the specified name.
     *
     * @param name The name of the argument.
     */
    public ArgumentBuilder(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the argument.
     *
     * @param description The description of the argument.
     * @return The ArgumentBuilder instance.
     */
    public ArgumentBuilder<T> setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the permission check predicate for the argument.
     *
     * @param permissionCheck The predicate to check if the command sender has the required permission.
     * @return The ArgumentBuilder instance.
     */
    public ArgumentBuilder<T> setPermissionCheck(Predicate<CommandSender> permissionCheck) {
        this.permissionCheck = permissionCheck;
        return this;
    }

    /**
     * Sets the validation rule predicate for the argument.
     *
     * @param validationRule The predicate to validate the argument value.
     * @return The ArgumentBuilder instance.
     */
    public ArgumentBuilder<T> setValidationRule(Predicate<String> validationRule) {
        this.validationRule = validationRule;
        return this;
    }

    /**
     * Builds and returns an instance of the {@link Argument} class with the configured properties.
     *
     * @return An instance of the Argument class.
     */
    public Argument<T> build() {
        return new Argument<>(name, description, permissionCheck, validationRule);
    }
}
