package lol.vifez.volt.api;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface CommandHandler {
    void execute(Player player, String[] args);

    default String getPermission() {
        return null;
    }
}