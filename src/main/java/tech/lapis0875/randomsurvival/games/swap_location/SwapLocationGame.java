package tech.lapis0875.randomsurvival.games.swap_location;

import net.kyori.adventure.text.Component;
import tech.lapis0875.randomsurvival.Constants;
import tech.lapis0875.randomsurvival.games.RSGame;

public class SwapLocationGame extends RSGame {
    private int delay;  // delay as seconds.

    public SwapLocationGame(int delay) throws IllegalStateException{
        super();
        this.delay = delay;
    }

    public SwapLocationGame() {
        this(Constants.DEFAULT_DELAY);
    }

    public void setDelay(int newDelay) {
        this.delay = newDelay;
    }

    public int getDelay() {
        return this.delay;
    }

    @Override
    public void start() {
        this.plugin.getServer().sendMessage(Component.text("SwapLocation 게임을 시작합니다.", Constants.COLOR_GREEN));
        this.collectPlayers();
        this.scheduledTask = new SwapLocationRunnable(this.plugin, this.players);
        this.scheduledTask.runTaskTimer(this.plugin, 0, 20L * this.delay);
    }

    @Override
    public void stop() {
        this.plugin.getServer().sendMessage(Component.text("SwapLocation 게임을 종료합니다.", Constants.COLOR_GREEN));
        super.stop();
    }
}
