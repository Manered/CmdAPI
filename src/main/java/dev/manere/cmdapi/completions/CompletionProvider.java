package dev.manere.cmdapi.completions;

import java.util.List;

/**
 * The CompletionProvider interface represents a provider for tab completions.
 */
public interface CompletionProvider {
    /**
     * Provides a list of completions for the given input.
     *
     * @param input the input string
     * @return a list of completions
     */
    List<String> provideCompletions(String input);
}
