package dev.manere.cmdapi.util;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class PermissionUtil {
    public static boolean hasPermission(CommandSender sender, String permission) {
        return sender.hasPermission(permission);
    }

    public static void setDefaultPermission(Permission permission, PermissionDefault defaultValue) {
        permission.setDefault(defaultValue);
    }
}
