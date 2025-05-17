package lol.vifez.volt.internal;

import lol.vifez.volt.api.CommandBase;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
    private final List<CommandBase> commands = new ArrayList<>();

    public void add(CommandBase base) {
        commands.add(base);
    }

    public List<CommandBase> getCommands() {
        return commands;
    }
}