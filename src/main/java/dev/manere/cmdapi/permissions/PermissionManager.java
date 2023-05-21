package dev.manere.cmdapi.permissions;

import org.bukkit.entity.Player;

/**
 * The PermissionManager class provides utility methods for checking permissions.
 */
public class PermissionManager {
    /**
     * Checks if a player has the given permission.
     *
     * @param player     the player to check
     * @param permission the permission to check for
     * @return true if the player has the permission, false otherwise
     */
    public boolean hasPermission(Player player, String permission) {
        return player.hasPermission(permission);
    }
}
