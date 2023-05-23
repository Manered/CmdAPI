package dev.manere.cmdapi.argument;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TabCompletionBuilder {
    private final List<String> completions = new ArrayList<>();
    private Predicate<CommandSender> permissionCheck = sender -> true;
    private Function<String, List<String>> dynamicCompletions = input -> new ArrayList<>();

    public TabCompletionBuilder addCompletions(String... completions) {
        this.completions.addAll(Arrays.asList(completions));
        return this;
    }

    public TabCompletionBuilder setPermissionCheck(Predicate<CommandSender> permissionCheck) {
        this.permissionCheck = permissionCheck;
        return this;
    }

    public TabCompletionBuilder setDynamicCompletions(Function<String, List<String>> dynamicCompletions) {
        this.dynamicCompletions = dynamicCompletions;
        return this;
    }

    public List<String> getCompletions(CommandSender sender, String input) {
        if (!permissionCheck.test(sender)) {
            return new ArrayList<>();
        }

        List<String> completions = new ArrayList<>(this.completions);
        completions.addAll(dynamicCompletions.apply(input));
        return completions;
    }
}
