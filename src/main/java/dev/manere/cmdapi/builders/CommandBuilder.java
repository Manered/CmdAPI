package dev.manere.cmdapi.builders;

import org.bukkit.command.*;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import dev.manere.cmdapi.util.ColorUtils;

/**
 * A builder class for creating Bukkit commands.
 */
public class CommandBuilder {
    private final Plugin plugin;
    private String name;
    private String description;
    private String permission;
    private String usage;
    private String permissionMessage;
    private BiConsumer<CommandSender, String[]> commandExecutor;
    private final List<TabCompletion> tabCompletions;
    private List<String> aliases;

    /**
     * Creates a new CommandBuilder instance.
     *
     * @param plugin the plugin that owns the command
     */
    public CommandBuilder(Plugin plugin) {
        this.plugin = plugin;
        this.tabCompletions = new ArrayList<>();
        this.aliases = new ArrayList<>();
    }

    /**
     * Sets the name of the command.
     *
     * @param name the name of the command
     * @return the CommandBuilder instance
     */
    public CommandBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the description of the command.
     *
     * @param description the description of the command
     * @return the CommandBuilder instance
     */
    public CommandBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the permission required to use the command.
     *
     * @param permission the permission required to use the command
     * @return the CommandBuilder instance
     */
    public CommandBuilder setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    /**
     * Sets the executor for the command.
     *
     * @param commandExecutor the executor for the command
     * @return the CommandBuilder instance
     */
    public CommandBuilder setExecutor(BiConsumer<CommandSender, String[]> commandExecutor) {
        this.commandExecutor = commandExecutor;
        return this;
    }

    /**
     * Adds a tab completion for the command argument at the specified index.
     *
     * @param argumentIndex the index of the argument to add tab completion for
     * @param tabCompleter  the TabCompleter instance for the argument
     * @return the CommandBuilder instance
     */
    public CommandBuilder addTabCompletion(int argumentIndex, TabCompleter tabCompleter) {
        this.tabCompletions.add(new TabCompletion(argumentIndex, tabCompleter));
        return this;
    }

    /**
     * Sets the usage string for the command.
     *
     * @param usage the usage string for the command
     * @return the CommandBuilder instance
     */
    public CommandBuilder setUsage(String usage) {
        this.usage = ColorUtils.translate(usage);
        return this;
    }

    /**
     * Sets the aliases for the command.
     *
     * @param aliases the aliases for the command
     * @return the CommandBuilder instance
     */
    public CommandBuilder setAliases(String... aliases) {
        this.aliases = Arrays.asList(aliases);
        return this;
    }

    /**
     * Sets the permission message to be displayed when a player lacks the required permission.
     *
     * @param permissionMessage the permission message
     * @return the CommandBuilder instance
     */
    public CommandBuilder setPermissionMessage(String permissionMessage) {
        this.permissionMessage = ColorUtils.translate(permissionMessage);
        return this;
    }

    /**
     * Builds and registers the command with the plugin.
     *
     * @return the built Command instance
     * @throws IllegalArgumentException if the command is not found in plugin.yml
     */
    public Command build() {
        PluginCommand pluginCommand = plugin.getServer().getPluginCommand(name);
        if (pluginCommand == null) {
            throw new IllegalArgumentException("Command '" + name + "' not found in plugin.yml");
        }

        pluginCommand.setDescription(description);
        pluginCommand.setPermission(permission);
        pluginCommand.setUsage(usage);
        pluginCommand.setAliases(aliases);
        pluginCommand.setPermissionMessage(permissionMessage);
        pluginCommand.setExecutor((sender, command, label, args) -> {
            if (commandExecutor != null) {
                commandExecutor.accept(sender, args);
            }
            return true;
        });

        pluginCommand.setTabCompleter((sender, command, alias, args) -> {
            if (!tabCompletions.isEmpty()) {
                for (TabCompletion tabCompletion : tabCompletions) {
                    if (args.length - 1 == tabCompletion.argumentIndex) {
                        return tabCompletion.tabCompleter.onTabComplete(sender, command, alias, args);
                    }
                }
            }
            return null;
        });

        return pluginCommand;
    }

    private static class TabCompletion {
        private final int argumentIndex;
        private final TabCompleter tabCompleter;

        public TabCompletion(int argumentIndex, TabCompleter tabCompleter) {
            this.argumentIndex = argumentIndex;
            this.tabCompleter = tabCompleter;
        }
    }
}
