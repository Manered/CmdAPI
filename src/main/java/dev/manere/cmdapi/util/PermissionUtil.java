package dev.manere.cmdapi.util;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

/**
 * Utility class for handling permissions.
 */
public class PermissionUtil {
    /**
     * Checks if the specified sender has the given permission.
     *
     * @param sender     The CommandSender to check the permission for.
     * @param permission The permission to check.
     * @return {@code true} if the sender has the permission, {@code false} otherwise.
     */
    public static boolean hasPermission(CommandSender sender, String permission) {
        return sender.hasPermission(permission);
    }

    /**
     * Sets the default value for a permission.
     *
     * @param permission    The permission to set the default value for.
     * @param defaultValue The default value to set.
     */
    public static void setDefaultPermission(Permission permission, PermissionDefault defaultValue) {
        permission.setDefault(defaultValue);
    }
}
