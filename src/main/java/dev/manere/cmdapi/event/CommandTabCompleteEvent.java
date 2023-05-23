package dev.manere.cmdapi.event;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Custom event triggered when tab completion is performed on a command.
 */
public class CommandTabCompleteEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final CommandSender sender;
    private final String[] args;
    private List<String> completions;

    /**
     * Constructs a CommandTabCompleteEvent with the specified sender and arguments.
     *
     * @param sender The command sender.
     * @param args   The command arguments.
     */
    public CommandTabCompleteEvent(CommandSender sender, String[] args) {
        this.sender = sender;
        this.args = args;
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
     * Gets the command arguments.
     *
     * @return The command arguments.
     */
    public String[] getArgs() {
        return args;
    }

    /**
     * Gets the list of tab completions.
     *
     * @return The list of tab completions.
     */
    public List<String> getCompletions() {
        return completions;
    }

    /**
     * Sets the list of tab completions.
     *
     * @param completions The list of tab completions.
     */
    public void setCompletions(List<String> completions) {
        this.completions = completions;
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
