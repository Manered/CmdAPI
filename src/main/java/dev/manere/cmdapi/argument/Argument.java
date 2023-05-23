package dev.manere.cmdapi.argument;

import org.bukkit.command.CommandSender;

import java.util.function.Predicate;

public class Argument<T> {
    private final String name;
    private final String description;
    private final Predicate<CommandSender> permissionCheck;
    private final Predicate<String> validationRule;

    public Argument(String name, String description, Predicate<CommandSender> permissionCheck, Predicate<String> validationRule) {
        this.name = name;
        this.description = description;
        this.permissionCheck = permissionCheck;
        this.validationRule = validationRule;
    }

    // Add any additional methods or functionality you require for the Argument class

    // Placeholder methods to satisfy the compilation
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Predicate<CommandSender> getPermissionCheck() {
        return permissionCheck;
    }

    public Predicate<String> getValidationRule() {
        return validationRule;
    }
}
