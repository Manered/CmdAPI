package dev.manere.cmdapi.argument;

import org.bukkit.command.CommandSender;

import java.util.function.Predicate;

/**
 * Represents an argument for a command.
 *
 * @param <T> The type of the argument value.
 */
public class Argument<T> {
    private final String name;
    private final String description;
    private final Predicate<CommandSender> permissionCheck;
    private final Predicate<String> validationRule;

    /**
     * Constructs an Argument with the specified properties.
     *
     * @param name The name of the argument.
     * @param description The description of the argument.
     * @param permissionCheck The predicate to check if the command sender has the required permission.
     * @param validationRule The predicate to validate the argument value.
     */
    public Argument(String name, String description, Predicate<CommandSender> permissionCheck, Predicate<String> validationRule) {
        this.name = name;
        this.description = description;
        this.permissionCheck = permissionCheck;
        this.validationRule = validationRule;
    }

    // Add any additional methods or functionality you require for the Argument class

    /**
     * Returns the name of the argument.
     *
     * @return The name of the argument.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the argument.
     *
     * @return The description of the argument.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the predicate to check if the command sender has the required permission.
     *
     * @return The permission check predicate.
     */
    public Predicate<CommandSender> getPermissionCheck() {
        return permissionCheck;
    }

    /**
     * Returns the predicate to validate the argument value.
     *
     * @return The validation rule predicate.
     */
    public Predicate<String> getValidationRule() {
        return validationRule;
    }
}
