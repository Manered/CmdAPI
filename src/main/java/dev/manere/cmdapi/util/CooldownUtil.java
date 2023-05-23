package dev.manere.cmdapi.util;

import java.util.HashMap;
import java.util.Map;

public class CooldownUtil {
    private static final Map<String, Long> cooldowns = new HashMap<>();

    public static boolean checkCooldown(String player, int cooldownDuration) {
        if (cooldownDuration > 0) {
            long lastExecution = cooldowns.getOrDefault(player, 0L);
            long now = System.currentTimeMillis();
            return now - lastExecution >= cooldownDuration * 1000L;
        }
        return true;
    }

    public static void applyCooldown(String player) {
        cooldowns.put(player, System.currentTimeMillis());
    }
}
