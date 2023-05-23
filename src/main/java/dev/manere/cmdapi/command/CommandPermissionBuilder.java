package dev.manere.cmdapi.command;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Builder class for managing command permissions.
 */
public class CommandPermissionBuilder {
    private final Set<String> permissions = new HashSet<>();

    /**
     * Adds a permission to the set of command permissions.
     *
     * @param permission The permission to add.
     * @return The CommandPermissionBuilder instance.
     */
    public CommandPermissionBuilder addPermission(String permission) {
        permissions.add(permission);
        return this;
    }

    /**
     * Adds multiple permissions to the set of command permissions.
     *
     * @param permissions The permissions to add.
     * @return The CommandPermissionBuilder instance.
     */
    public CommandPermissionBuilder addPermissions(String... permissions) {
        this.permissions.addAll(Arrays.asList(permissions));
        return this;
    }

    /**
     * Adds a parent permission to all the command permissions.
     *
     * @param parent The parent permission to add.
     * @return The CommandPermissionBuilder instance.
     */
    public CommandPermissionBuilder addParent(Permission parent) {
        for (String permission : permissions) {
            Permission perm = new Permission(permission);
            perm.addParent(parent, true);
        }
        return this;
    }

    /**
     * Adds a parent permission to all the command permissions.
     *
     * @param parent The name of the parent permission to add.
     * @return The CommandPermissionBuilder instance.
     */
    public CommandPermissionBuilder addParent(String parent) {
        for (String permission : permissions) {
            Permission perm = new Permission(permission);
            perm.addParent(parent, true);
        }
        return this;
    }

    /**
     * Checks if the command sender has all the required permissions.
     *
     * @param sender The command sender to check.
     * @return {@code true} if the command sender has all the required permissions, {@code false} otherwise.
     */
    public boolean hasPermission(CommandSender sender) {
        for (String permission : permissions) {
            if (!sender.hasPermission(permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Registers all the command permissions.
     * Permissions will have the default value of "OP" (operator).
     */
    public void registerPermissions() {
        for (String permission : permissions) {
            Permission perm = new Permission(permission);
            perm.setDefault(PermissionDefault.OP);
        }
    }
}
