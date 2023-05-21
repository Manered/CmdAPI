package dev.manere.cmdapi.builders;

import dev.manere.cmdapi.completions.CompletionProvider;

/**
 * The TabCompletionBuilder class is used to build tab completion providers.
 */
public class TabCompletionBuilder {
    private final CompletionProvider completionProvider;

    /**
     * Constructs a new TabCompletionBuilder instance with the specified completion provider.
     *
     * @param completionProvider the completion provider
     */
    public TabCompletionBuilder(CompletionProvider completionProvider) {
        this.completionProvider = completionProvider;
    }

    /**
     * Builds and returns the completion provider.
     *
     * @return the completion provider
     */
    public CompletionProvider build() {
        return completionProvider;
    }
}
