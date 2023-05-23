package dev.manere.cmdapi.registry;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;

import java.lang.reflect.Field;

/**
 * Registry class for registering custom commands using the Bukkit CommandMap.
 */
public class CommandBuilderRegistry {
    private static CommandMap commandMap;

    static {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Registers a custom command with the Bukkit CommandMap.
     *
     * @param command The command to register.
     */
    public static void registerCommand(Command command) {
        commandMap.register(command.getName(), command);
        command.setLabel(command.getName()); // Set the label to the command name
    }
}
