package dev.manere.cmdapi.arguments;

import dev.manere.cmdapi.exceptions.ArgumentParseException;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.UUID;

public class OfflinePlayerArgument implements Argument<OfflinePlayer> {

    @Override
    public OfflinePlayer parse(CommandSender sender, String input) throws ArgumentParseException {
        OfflinePlayer offlinePlayer;
        if (input.length() <= 16) {

            offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(input));
        } else {
            try {
                UUID uuid = UUID.fromString(input);
                offlinePlayer = Bukkit.getOfflinePlayer(uuid);
            } catch (IllegalArgumentException e) {
                throw new ArgumentParseException("Invalid player: " + input);
            }
        }

        if (!offlinePlayer.hasPlayedBefore() && !offlinePlayer.isOnline()) {
            throw new ArgumentParseException("Player not found: " + input);
        }

        return offlinePlayer;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String input) {
        return null;
    }
}
