package dev.manere.cmdapi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * The CommandManager class is responsible for managing commands and their execution.
 */
public class CommandManager {
    private final Map<String, CommandExecutor> commands;

    /**
     * Constructs a new CommandManager instance.
     */
    public CommandManager() {
        commands = new HashMap<>();
    }

    /**
     * Registers a command with the specified label and executor.
     *
     * @param label    the label of the command
     * @param executor the command executor
     */
    public void registerCommand(String label, CommandExecutor executor) {
        Command command = new Command(label) {
            @Override
            public boolean execute(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {
                if (executor != null) {
                    executor.execute(sender, args);
                    return true;
                }
                return false;
            }
        };
        getCommandMap().register("", command);
        commands.put(label, executor);
    }

    /**
     * Unregisters a command with the specified label.
     *
     * @param label the label of the command to unregister
     */
    public void unregisterCommand(String label) {
        commands.remove(label);
    }

    /**
     * Retrieves the command executor for the command with the specified label.
     *
     * @param label the label of the command
     * @return the command executor
     */
    public CommandExecutor getCommandExecutor(String label) {
        return commands.get(label);
    }

    private CommandMap getCommandMap() {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            return (CommandMap) commandMapField.get(Bukkit.getServer());
        } catch (NoSuchFieldException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
