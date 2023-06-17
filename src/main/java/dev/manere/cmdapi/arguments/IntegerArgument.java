package dev.manere.cmdapi.arguments;

import dev.manere.cmdapi.exceptions.ArgumentParseException;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class IntegerArgument implements Argument<Integer> {

    @Override
    public Integer parse(CommandSender sender, String input) throws ArgumentParseException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ArgumentParseException("Invalid integer: " + input);
        }
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String input) {
        return null;
    }
}
