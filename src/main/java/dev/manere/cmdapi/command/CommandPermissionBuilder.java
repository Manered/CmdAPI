package dev.manere.cmdapi.command;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import java.util.HashSet;
import java.util.Set;

public class CommandPermissionBuilder {
    private final Set<String> permissions = new HashSet<>();

    public CommandPermissionBuilder addPermission(String permission) {
        permissions.add(permission);
        return this;
    }

    public CommandPermissionBuilder addPermissions(String... permissions) {
        for (String permission : permissions) {
            this.permissions.add(permission);
        }
        return this;
    }

    public CommandPermissionBuilder addParent(Permission parent) {
        for (String permission : permissions) {
            Permission perm = new Permission(permission);
            perm.addParent(parent, true);
        }
        return this;
    }

    public CommandPermissionBuilder addParent(String parent) {
        for (String permission : permissions) {
            Permission perm = new Permission(permission);
            perm.addParent(parent, true);
        }
        return this;
    }

    public boolean hasPermission(CommandSender sender) {
        for (String permission : permissions) {
            if (!sender.hasPermission(permission)) {
                return false;
            }
        }
        return true;
    }

    public void registerPermissions() {
        for (String permission : permissions) {
            Permission perm = new Permission(permission);
            perm.setDefault(PermissionDefault.OP);
        }
    }
}
