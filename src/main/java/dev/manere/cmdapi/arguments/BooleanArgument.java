package dev.manere.cmdapi.arguments;

import dev.manere.cmdapi.exceptions.ArgumentParseException;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class BooleanArgument implements Argument<Boolean> {

    @Override
    public Boolean parse(CommandSender sender, String input) throws ArgumentParseException {
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("on") || input.equalsIgnoreCase("enabled")) {
            return true;
        } else if (input.equalsIgnoreCase("false") || input.equalsIgnoreCase("no") || input.equalsIgnoreCase("off") || input.equalsIgnoreCase("disabled")) {
            return false;
        } else {
            throw new ArgumentParseException("Invalid boolean: " + input);
        }
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String input) {
        return Arrays.asList("true", "false", "yes", "no", "on", "off", "enabled", "disabled");
    }
}
