package dev.manere.cmdapi.argument;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Builder class for creating tab completions for a command.
 */
public class TabCompletionBuilder {
    private final List<String> completions = new ArrayList<>();
    private Predicate<CommandSender> permissionCheck = sender -> true;
    private Function<String, List<String>> dynamicCompletions = input -> new ArrayList<>();

    /**
     * Adds static completions to the list of tab completions.
     *
     * @param completions The completions to add.
     * @return The TabCompletionBuilder instance.
     */
    public TabCompletionBuilder addCompletions(String... completions) {
        this.completions.addAll(Arrays.asList(completions));
        return this;
    }

    /**
     * Sets the permission check predicate for the tab completions.
     *
     * @param permissionCheck The predicate to check if the command sender has the required permission.
     * @return The TabCompletionBuilder instance.
     */
    public TabCompletionBuilder setPermissionCheck(Predicate<CommandSender> permissionCheck) {
        this.permissionCheck = permissionCheck;
        return this;
    }

    /**
     * Sets the dynamic completions function for the tab completions.
     *
     * @param dynamicCompletions The function to generate dynamic completions based on the input.
     * @return The TabCompletionBuilder instance.
     */
    public TabCompletionBuilder setDynamicCompletions(Function<String, List<String>> dynamicCompletions) {
        this.dynamicCompletions = dynamicCompletions;
        return this;
    }

    /**
     * Retrieves the list of tab completions based on the command sender and input.
     *
     * @param sender The command sender.
     * @param input The input string.
     * @return The list of tab completions.
     */
    public List<String> getCompletions(CommandSender sender, String input) {
        if (!permissionCheck.test(sender)) {
            return new ArrayList<>();
        }

        List<String> completions = new ArrayList<>(this.completions);
        completions.addAll(dynamicCompletions.apply(input));
        return completions;
    }
}
