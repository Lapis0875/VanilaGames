package tech.lapis0875.randomsurvival.games.swap_location;

import tech.lapis0875.randomsurvival.Constants;
import tech.lapis0875.randomsurvival.games.RSGame;

public class SwapLocationGame extends RSGame {
    private int delay;  // delay as seconds.
    public SwapLocationGame(int delay) {
        super();
        this.delay = delay;
    }
    public SwapLocationGame() {
        this(Constants.DEFAULT_DELAY);
    }
    @Override
    public void start() {
        this.collectPlayers();
        this.scheduledTask = new SwapLocationRunnable(this.plugin, this.players);
        this.scheduledTask.runTaskTimer(this.plugin, 0, 20L * this.delay);
    }
}
