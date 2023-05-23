package dev.manere.cmdapi.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Builder class for creating Bukkit commands.
 */
public class CommandBuilder {
    private final String name;
    private String description = "";
    private String permission = "";
    private String[] aliases = new String[0];
    private CommandExecutor executor;
    private final Plugin plugin;

    /**
     * Constructs a CommandBuilder with the specified name and plugin.
     *
     * @param name   The name of the command.
     * @param plugin The plugin instance.
     */
    public CommandBuilder(String name, Plugin plugin) {
        this.name = name;
        this.plugin = plugin;
    }

    /**
     * Sets the description of the command.
     *
     * @param description The description of the command.
     * @return The CommandBuilder instance.
     */
    public CommandBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the permission required to execute the command.
     *
     * @param permission The permission required to execute the command.
     * @return The CommandBuilder instance.
     */
    public CommandBuilder setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    /**
     * Sets the aliases for the command.
     *
     * @param aliases The aliases for the command.
     * @return The CommandBuilder instance.
     */
    public CommandBuilder setAliases(String... aliases) {
        this.aliases = aliases;
        return this;
    }

    /**
     * Sets the executor for the command.
     *
     * @param executor The executor to handle command execution.
     * @return The CommandBuilder instance.
     */
    public CommandBuilder setExecutor(CommandExecutor executor) {
        this.executor = executor;
        return this;
    }

    /**
     * Builds and registers the command with the Bukkit server.
     */
    public void register() {
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

        // Register the command with the Bukkit server
        registerCommand(command);
    }

    private void registerCommand(Command command) {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            SimpleCommandMap commandMap = (SimpleCommandMap) commandMapField.get(Bukkit.getServer());
            commandMap.register(plugin.getDescription().getName(), command);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
