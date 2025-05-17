package lol.vifez.volt.internal;

import lol.vifez.volt.api.CommandBase;
import lol.vifez.volt.api.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.*;

public class CommandManager {

    private final JavaPlugin plugin;
    private final CommandRegistry registry = new CommandRegistry();

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register(CommandBase base) {
        for (String alias : base.getAliases()) {
            PluginCommandWrapper wrapper = new PluginCommandWrapper(alias, base);
            getCommandMap().register(plugin.getDescription().getName(), wrapper);
        }
        registry.add(base);
    }

    private CommandMap getCommandMap() {
        try {
            Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            return (CommandMap) f.get(Bukkit.getServer());
        } catch (Exception e) {
            throw new RuntimeException("Failed to get CommandMap", e);
        }
    }

    private static class PluginCommandWrapper extends Command {
        private final CommandBase base;

        protected PluginCommandWrapper(String name, CommandBase base) {
            super(name);
            this.base = base;
        }

        @Override
        public boolean execute(CommandSender sender, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cOnly players can use this command.");
                return true;
            }

            Player player = (Player) sender;
            if (args.length == 0) {
                if (base.getDefaultHandler() != null) {
                    base.getDefaultHandler().execute(player, args);
                }
                return true;
            }

            CommandHandler sub = base.getSubcommands().get(args[0].toLowerCase());
            if (sub != null) {
                sub.execute(player, Arrays.copyOfRange(args, 1, args.length));
                return true;
            }

            player.sendMessage("§cUnknown command.");
            return true;
        }
    }
}