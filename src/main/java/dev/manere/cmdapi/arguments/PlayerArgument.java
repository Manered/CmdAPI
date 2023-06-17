package dev.manere.cmdapi.arguments;

import dev.manere.cmdapi.exceptions.ArgumentParseException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerArgument implements Argument<Player> {

    @Override
    public Player parse(CommandSender sender, String input) throws ArgumentParseException {
        Player player = Bukkit.getPlayer(input);
        if (player == null) {
            throw new ArgumentParseException("Player not found: " + input);
        }
        return player;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String input) {
        List<String> completions = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            String playerName = player.getName();
            if (playerName.startsWith(input)) {
                completions.add(playerName);
            }
        }
        return completions;
    }
}
