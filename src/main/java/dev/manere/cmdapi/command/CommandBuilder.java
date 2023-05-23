package dev.manere.cmdapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class CommandBuilder {
    private final String name;
    private String description = "";
    private String permission = "";
    private String[] aliases = new String[0];
    private CommandExecutor executor;

    public CommandBuilder(String name) {
        this.name = name;
    }

    public CommandBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public CommandBuilder setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public CommandBuilder setAliases(String... aliases) {
        this.aliases = aliases;
        return this;
    }

    public CommandBuilder setExecutor(CommandExecutor executor) {
        this.executor = executor;
        return this;
    }

    public Command build() {
        Command command = new Command(name) {
            @Override
            public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, String[] args) {
                if (executor != null) {
                    return executor.onCommand(sender, this, commandLabel, args);
                }
                return false;
            }
        };
        command.setDescription(description);
        command.setPermission(permission);
        command.setAliases(Arrays.asList(aliases));
        return command;
    }
}
