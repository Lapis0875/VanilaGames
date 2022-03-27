package tech.lapis0875.randomsurvival.games.item_removal;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import tech.lapis0875.randomsurvival.Constants;
import tech.lapis0875.randomsurvival.games.RSGameRunnable;

import java.util.List;
import java.util.Random;

public class ItemRemovalRunnable extends RSGameRunnable {
    public ItemRemovalRunnable(Plugin plugin, List<Player> players) {
        super(plugin, players);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        for (Player p: this.players) {
            Inventory inv = p.getInventory();
            int invSize = inv.getSize();

        }
        this.plugin.getServer().sendMessage(Component.text("다른 플레이어와 위치를 바꿨습니다!", Constants.COLOR_GREEN));
    }

    private int getRandomIndex(Random rnd, int invSize) {
        return rnd.nextInt(invSize);
    }
}
