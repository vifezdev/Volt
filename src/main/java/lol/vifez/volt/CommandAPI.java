package lol.vifez.volt;

import lol.vifez.volt.internal.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandAPI {

    private static CommandManager manager;

    public static void init(JavaPlugin plugin) {
        manager = new CommandManager(plugin);
    }

    public static CommandManager getManager() {
        return manager;
    }
}