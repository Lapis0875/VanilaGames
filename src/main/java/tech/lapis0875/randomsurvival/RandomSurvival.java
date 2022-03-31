package tech.lapis0875.randomsurvival;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import tech.lapis0875.randomsurvival.commands.RSCommandExecutor;

import java.util.Objects;

public final class RandomSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("RandomSurvival is loaded. Registering CommandExecutor...");
        CommandExecutor commandExecutor = new RSCommandExecutor();
        Objects.requireNonNull(getCommand(Constants.Commands.RS)).setExecutor(commandExecutor);
        Bukkit.getLogger().info("Done! Successfully enabled RS!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("RandomSurvival is unloaded.");
    }
}
