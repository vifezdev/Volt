package lol.vifez.volt.internal;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ArgumentParser {

    public static Player parsePlayer(String name) {
        return Bukkit.getPlayerExact(name);
    }
}