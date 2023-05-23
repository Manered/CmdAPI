package dev.manere.cmdapi.event;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Custom event triggered when a command is executed.
 */
public class CommandExecutionEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final CommandSender sender;

    /**
     * Constructs a CommandExecutionEvent with the specified sender.
     *
     * @param sender The command sender.
     */
    public CommandExecutionEvent(CommandSender sender) {
        this.sender = sender;
    }

    /**
     * Gets the command sender.
     *
     * @return The command sender.
     */
    public CommandSender getSender() {
        return sender;
    }

    /**
     * Gets the HandlerList for the event.
     *
     * @return The HandlerList for the event.
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
