package tech.lapis0875.randomsurvival;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import tech.lapis0875.randomsurvival.commands.RSCommandExecutor;

import java.util.Objects;

public final class RandomSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandExecutor commandExecutor = new RSCommandExecutor();
        Objects.requireNonNull(getCommand(Constants.Commands.RS)).setExecutor(commandExecutor);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
