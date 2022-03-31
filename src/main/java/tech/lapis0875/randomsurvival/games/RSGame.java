package tech.lapis0875.randomsurvival.games;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import tech.lapis0875.randomsurvival.Constants;

import java.util.ArrayList;
import java.util.List;

public class RSGame {
    protected BukkitRunnable scheduledTask;
    protected final Plugin plugin;
    private final Server server;
    protected final List<Player> players;

    public RSGame() {
        this.plugin = Bukkit.getPluginManager().getPlugin(Constants.PLUGIN_NAME);
        this.server = plugin.getServer();
        this.players = new ArrayList<>();
    }

    public BukkitRunnable getScheduledTask() {
        return this.scheduledTask;
    }

    public void collectPlayers() {
        this.players.clear();
        this.players.addAll(
                this.server.getOnlinePlayers().stream().filter(
                        (p) -> !p.getGameMode().equals(GameMode.SPECTATOR)
                ).toList()
        );
        this.plugin.getServer().sendMessage(Component.text(
                String.format("게임에 참가한 플레이어 수 : %d", this.players.size()),
                Constants.COLOR_GREEN
        ));
        for (Player p: this.players) {
            this.plugin.getServer().sendMessage(Component.text(
                    String.format("- %s", p.getName()),
                    Constants.COLOR_GREEN
            ));
        }
    }

    public void start() {
        this.collectPlayers();
        this.scheduledTask = new RSGameRunnable(this.plugin, this.players);
        this.scheduledTask.runTaskTimer(this.plugin, 0, 1200);
    }

    public void stop() {
        try {
            this.scheduledTask.cancel();
        } catch (IllegalStateException ignored) {}
        this.players.clear();
    }

    public boolean isRunning() {
        try {
            return !this.scheduledTask.isCancelled();
        } catch (IllegalStateException e) {
            return false;
        }
    }
}
