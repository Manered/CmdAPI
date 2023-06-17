package dev.manere.cmdapi.arguments;

import dev.manere.cmdapi.exceptions.ArgumentParseException;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class DoubleArgument implements Argument<Double> {

    @Override
    public Double parse(CommandSender sender, String input) throws ArgumentParseException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new ArgumentParseException("Invalid double: " + input);
        }
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String input) {
        return null;
    }
}
