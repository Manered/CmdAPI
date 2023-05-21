package dev.manere.cmdapi.builders;

import dev.manere.cmdapi.arguments.ArgumentType;
import dev.manere.cmdapi.commands.CommandExecutor;
import dev.manere.cmdapi.commands.CommandManager;
import dev.manere.cmdapi.completions.CompletionProvider;
import dev.manere.cmdapi.exceptions.CommandException;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * The CommandBuilder class is responsible for building commands with various properties.
 */
public class CommandBuilder {
    private final String label;
    private final CommandManager commandManager;
    private final List<ArgumentBuilder<?>> argumentBuilders;
    private CommandExecutor executor;
    private CompletionProvider completionProvider;
    private String permission;
    private String permissionMessage;

    /**
     * Constructs a new CommandBuilder instance with the specified label and command manager.
     *
     * @param label          the label of the command
     * @param commandManager the command manager
     */
    public CommandBuilder(String label, CommandManager commandManager) {
        this.label = label;
        this.commandManager = commandManager;
        this.argumentBuilders = new ArrayList<>();
        this.executor = null;
        this.completionProvider = null;
        this.permission = null;
        this.permissionMessage = null;
    }

    /**
     * Adds an argument to the command using the specified argument type.
     *
     * @param argumentType the argument type
     * @param <T>          the type of the argument
     * @return the ArgumentBuilder instance for further configuration
     */
    public <T> ArgumentBuilder<T> argument(ArgumentType<T> argumentType) {
        ArgumentBuilder<T> argumentBuilder = new ArgumentBuilder<>(argumentType);
        argumentBuilders.add(argumentBuilder);
        return argumentBuilder;
    }

    /**
     * Sets the executor for the command.
     *
     * @param executor the command executor
     * @return the CommandBuilder instance
     */
    public CommandBuilder executor(CommandExecutor executor) {
        this.executor = executor;
        return this;
    }

    /**
     * Sets the completion provider for the command.
     *
     * @param completionProvider the completion provider
     * @return the CommandBuilder instance
     */
    public CommandBuilder completionProvider(CompletionProvider completionProvider) {
        this.completionProvider = completionProvider;
        return this;
    }

    /**
     * Sets the permission required to execute the command.
     *
     * @param permission the permission
     * @return the CommandBuilder instance
     */
    public CommandBuilder permission(String permission) {
        this.permission = permission;
        return this;
    }

    /**
     * Sets the permission message to be displayed when a player does not have the required permission.
     *
     * @param permissionMessage the permission message
     * @return the CommandBuilder instance
     */
    public CommandBuilder permissionMessage(String permissionMessage) {
        this.permissionMessage = permissionMessage;
        return this;
    }

    /**
     * Registers the built command with the command manager.
     */
    public void register() {
        commandManager.registerCommand(label, (sender, args) -> {
            if (executor == null) {
                throw new CommandException("No executor defined for command: " + label);
            }

            if (permission != null && !sender.hasPermission(permission)) {
                if (permissionMessage != null) {
                    sender.sendMessage(permissionMessage);
                }
                return;
            }

            if (completionProvider != null && args.length > 0) {
                List<String> completions = completionProvider.provideCompletions(args[args.length - 1]);
                sender.sendMessage(String.join(" ", completions));
                return;
            }

            Object[] parsedArgs = new Object[argumentBuilders.size()];
            for (int i = 0; i < argumentBuilders.size(); i++) {
                ArgumentBuilder<?> argumentBuilder = argumentBuilders.get(i);
                String input = (i < args.length) ? args[i] : "";
                parsedArgs[i] = argumentBuilder.build().parse(input);
            }

            executor.execute(sender, args);
        });
    }
}
