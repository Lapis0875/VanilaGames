package tech.lapis0875.randomsurvival.games.swap_location;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import tech.lapis0875.randomsurvival.Constants;
import tech.lapis0875.randomsurvival.games.RSGameRunnable;

import java.util.Collections;
import java.util.List;

public class SwapLocationRunnable extends RSGameRunnable {
    public SwapLocationRunnable(Plugin plugin, List<Player> players) {
        super(plugin, players);
    }

    @Override
    public void run() {
        Collections.shuffle(this.players);
        for(int i=0; i<this.players.size(); i+=2) {
            Player p1 = this.players.get(i);
            Location l1 = p1.getLocation();
            if (i + 1 == this.players.size()) {
                break;
            }

            Player p2 = this.players.get(i + 1);
            Location l2 = p2.getLocation();
            p1.teleport(l2);
            p2.teleport(l1);

        }
        this.plugin.getServer().sendMessage(Component.text("다른 플레이어와 위치를 바꿨습니다!", Constants.COLOR_GREEN));
    }
}
