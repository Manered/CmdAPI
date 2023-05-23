package dev.manere.cmdapi.command;

import org.bukkit.command.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder class for creating command cooldown functionality.
 */
public class CommandCooldownBuilder {
    private final Command command;
    private final Map<String, Long> cooldowns = new HashMap<>();
    private int cooldownDuration = 0;
    private String cooldownMessage = "";

    /**
     * Constructs a CommandCooldownBuilder with the specified command.
     *
     * @param command The command to apply cooldown to.
     */
    public CommandCooldownBuilder(Command command) {
        this.command = command;
    }

    /**
     * Sets the duration of the cooldown in seconds.
     *
     * @param cooldownDuration The duration of the cooldown in seconds.
     * @return The CommandCooldownBuilder instance.
     */
    public CommandCooldownBuilder setCooldownDuration(int cooldownDuration) {
        this.cooldownDuration = cooldownDuration;
        return this;
    }

    /**
     * Sets the message to send to the player when they are on cooldown.
     *
     * @param cooldownMessage The message to send to the player when they are on cooldown.
     * @return The CommandCooldownBuilder instance.
     */
    public CommandCooldownBuilder setCooldownMessage(String cooldownMessage) {
        this.cooldownMessage = cooldownMessage;
        return this;
    }

    /**
     * Checks if the player is on cooldown for the command.
     *
     * @param player The player to check cooldown for.
     * @return {@code true} if the player is not on cooldown, {@code false} otherwise.
     */
    public boolean checkCooldown(String player) {
        if (cooldownDuration > 0) {
            long lastExecution = cooldowns.getOrDefault(player, 0L);
            long now = System.currentTimeMillis();
            return now - lastExecution >= cooldownDuration * 1000L;
        }
        return true;
    }

    /**
     * Applies the cooldown for the player on the command.
     *
     * @param player The player to apply the cooldown for.
     */
    public void applyCooldown(String player) {
        cooldowns.put(player, System.currentTimeMillis());
    }

    /**
     * Gets the cooldown message.
     *
     * @return The cooldown message.
     */
    public String getCooldownMessage() {
        return cooldownMessage;
    }
}
