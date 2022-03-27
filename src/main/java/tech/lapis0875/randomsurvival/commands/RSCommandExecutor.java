package tech.lapis0875.randomsurvival.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lapis0875.randomsurvival.Constants;
import tech.lapis0875.randomsurvival.games.RSGame;
import tech.lapis0875.randomsurvival.games.swap_location.SwapLocationGame;

import java.util.ArrayList;
import java.util.List;

public class RSCommandExecutor implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        switch (args[0]) {
            case Constants.Commands.OPT_START -> {
                switch (args[1]) {
                    case Constants.Games.SWAP_LOCATION -> {
                        RSGame game;
                        if (args.length > 2) {
                            game = new SwapLocationGame(Integer.parseInt(args[2]));
                        } else {
                            game = new SwapLocationGame();
                        }
                        game.start();
                    }
                    case Constants.Games.ITEM_REMOVAL -> {

                    }
                    case Constants.Games.RECIPE_RANDOMNESS -> {

                    }
                }
            }
            case Constants.Commands.OPT_STOP -> {

            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> tabCompletion = new ArrayList<>();
        if (command.getName().equals(Constants.Commands.RS)) {
            if (sender instanceof Player) {
                switch (args.length) {
                    case 1 -> {
                        tabCompletion.add(Constants.Commands.OPT_START);
                        tabCompletion.add(Constants.Commands.OPT_STOP);
                    }
                    case 2 -> {
                        tabCompletion.add(Constants.Games.SWAP_LOCATION);
                        tabCompletion.add(Constants.Games.ITEM_REMOVAL);
                        tabCompletion.add(Constants.Games.RECIPE_RANDOMNESS);
                    }
                }
            }
        }
        return tabCompletion;
    }
}
