package lol.vifez.volt.api;

import java.util.*;

public abstract class CommandBase {

    private final List<String> aliases = new ArrayList<>();
    private final Map<String, CommandHandler> subcommands = new HashMap<>();
    private String description;
    private CommandHandler defaultHandler;
    private String permission;

    public CommandBase() {
    }

    public void aliases(String... names) {
        aliases.addAll(Arrays.asList(names));
    }

    public void description(String desc) {
        this.description = desc;
    }

    public void defaultHandler(CommandHandler handler) {
        this.defaultHandler = handler;
    }

    public void sub(String name, CommandHandler handler) {
        subcommands.put(name.toLowerCase(), handler);
    }

    public void permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getDescription() {
        return description;
    }

    public CommandHandler getDefaultHandler() {
        return defaultHandler;
    }

    public Map<String, CommandHandler> getSubcommands() {
        return subcommands;
    }
}