package dev.manere.cmdapi.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for managing cooldowns.
 */
public class CooldownUtil {
    private static final Map<String, Long> cooldowns = new HashMap<>();

    /**
     * Checks if a player's cooldown has expired.
     *
     * @param player           The player's identifier.
     * @param cooldownDuration The duration of the cooldown in seconds.
     * @return `true` if the cooldown has expired, `false` otherwise.
     */
    public static boolean checkCooldown(String player, int cooldownDuration) {
        if (cooldownDuration > 0) {
            long lastExecution = cooldowns.getOrDefault(player, 0L);
            long now = System.currentTimeMillis();
            return now - lastExecution >= cooldownDuration * 1000L;
        }
        return true;
    }

    /**
     * Applies a cooldown to a player.
     *
     * @param player The player's identifier.
     */
    public static void applyCooldown(String player) {
        cooldowns.put(player, System.currentTimeMillis());
    }
}
