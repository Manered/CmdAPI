package dev.manere.cmdapi.arguments;

import dev.manere.cmdapi.exceptions.ArgumentParseException;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class FloatArgument implements Argument<Float> {

    @Override
    public Float parse(CommandSender sender, String input) throws ArgumentParseException {
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException e) {
            throw new ArgumentParseException("Invalid float: " + input);
        }
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String input) {
        return null;
    }
}
