package dev.manere.cmdapi.completions;

import java.util.ArrayList;
import java.util.List;

/**
 * The DynamicCompletionProvider class is an implementation of the CompletionProvider interface
 * that provides dynamic tab completions based on runtime conditions.
 */
public class DynamicCompletionProvider implements CompletionProvider {
    private final List<String> completions;

    /**
     * Constructs a new DynamicCompletionProvider instance.
     */
    public DynamicCompletionProvider() {
        completions = new ArrayList<>();
    }

    /**
     * Adds a completion to the list of dynamic completions.
     *
     * @param completion the completion string to add
     */
    public void addCompletion(String completion) {
        completions.add(completion);
    }

    /**
     * Provides a list of dynamic completions for the given input.
     *
     * @param input the input string
     * @return a list of completions
     */
    @Override
    public List<String> provideCompletions(String input) {
        return completions;
    }
}
