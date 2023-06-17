package dev.manere.cmdapi.arguments;

import dev.manere.cmdapi.exceptions.ArgumentParseException;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Represents an argument used in command execution.
 *
 * @param <T> the type of the argument
 */
public interface Argument<T> {

    /**
     * Parses the input string and converts it to the desired argument type.
     *
     * @param sender the command sender
     * @param input  the input string to parse
     * @return the parsed argument value
     * @throws ArgumentParseException if an error occurs while parsing the input
     */
    T parse(CommandSender sender, String input) throws ArgumentParseException;

    /**
     * Provides tab completion options for the argument based on the input string.
     *
     * @param sender the command sender
     * @param input  the input string for tab completion
     * @return a list of tab completion options
     */
    List<String> tabComplete(CommandSender sender, String input);
}
