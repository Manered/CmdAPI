package dev.manere.cmdapi.command;

import org.bukkit.command.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandCooldownBuilder {
    private final Command command;
    private final Map<String, Long> cooldowns = new HashMap<>();
    private int cooldownDuration = 0;
    private String cooldownMessage = "";

    public CommandCooldownBuilder(Command command) {
        this.command = command;
    }

    public CommandCooldownBuilder setCooldownDuration(int cooldownDuration) {
        this.cooldownDuration = cooldownDuration;
        return this;
    }

    public CommandCooldownBuilder setCooldownMessage(String cooldownMessage) {
        this.cooldownMessage = cooldownMessage;
        return this;
    }

    public boolean checkCooldown(String player) {
        if (cooldownDuration > 0) {
            long lastExecution = cooldowns.getOrDefault(player, 0L);
            long now = System.currentTimeMillis();
            return now - lastExecution >= cooldownDuration * 1000L;
        }
        return true;
    }

    public void applyCooldown(String player) {
        cooldowns.put(player, System.currentTimeMillis());
    }

    public String getCooldownMessage() {
        return cooldownMessage;
    }
}
