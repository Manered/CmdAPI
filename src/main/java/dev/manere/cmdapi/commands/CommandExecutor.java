package dev.manere.cmdapi.commands;

import org.bukkit.command.CommandSender;

/**
 * The CommandExecutor interface represents an executor for a command.
 */
public interface CommandExecutor {
    /**
     * Executes the command with the given sender and arguments.
     *
     * @param sender the command sender
     * @param args   the command arguments
     */
    void execute(CommandSender sender, String[] args);
}
