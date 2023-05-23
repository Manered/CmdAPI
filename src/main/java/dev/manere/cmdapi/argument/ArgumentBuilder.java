package dev.manere.cmdapi.argument;

import org.bukkit.command.CommandSender;

import java.util.function.Predicate;

public class ArgumentBuilder<T> {
    private final String name;
    private String description = "";
    private Predicate<CommandSender> permissionCheck = sender -> true;
    private Predicate<String> validationRule = argument -> true;

    public ArgumentBuilder(String name) {
        this.name = name;
    }

    public ArgumentBuilder<T> setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArgumentBuilder<T> setPermissionCheck(Predicate<CommandSender> permissionCheck) {
        this.permissionCheck = permissionCheck;
        return this;
    }

    public ArgumentBuilder<T> setValidationRule(Predicate<String> validationRule) {
        this.validationRule = validationRule;
        return this;
    }

    public Argument<T> build() {
        return new Argument<>(name, description, permissionCheck, validationRule);
    }
}
