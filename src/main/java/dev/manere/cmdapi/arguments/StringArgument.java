package dev.manere.cmdapi.arguments;

import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class StringArgument implements Argument<String> {

    @Override
    public String parse(CommandSender sender, String input) {
        return input;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String input) {
        return null;
    }
}
