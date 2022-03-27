package tech.lapis0875.randomsurvival.games;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class RSGameRunnable extends BukkitRunnable {
    protected final Plugin plugin;
    protected final List<Player> players;

    public RSGameRunnable(Plugin plugin, List<Player> players) {
        this.plugin = plugin;
        this.players = players;
    }

    @Override
    public void run() {
        // Implement Something
    }
}