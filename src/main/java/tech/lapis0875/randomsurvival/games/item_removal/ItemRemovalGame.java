package tech.lapis0875.randomsurvival.games.item_removal;

import tech.lapis0875.randomsurvival.Constants;
import tech.lapis0875.randomsurvival.games.RSGame;

public class ItemRemovalGame extends RSGame {

    private int delay;  // delay as second.
    private RemoveMode mode;

    public ItemRemovalGame(RemoveMode mode, int delay) {
        super();
        this.mode = mode;
        this.delay = delay;
    }

    public ItemRemovalGame(RemoveMode mode) {
        this(mode, Constants.DEFAULT_DELAY);
    }

    public ItemRemovalGame(int delay) {
        this(RemoveMode.Single, delay);
    }

    public ItemRemovalGame() {
        this(RemoveMode.Single, Constants.DEFAULT_DELAY);
    }

    public void setMode(RemoveMode mode) {
        this.mode = mode;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public RemoveMode getMode() {
        return this.mode;
    }

    public int getDelay() {
        return this.delay;
    }

    @Override
    public void start() {
        this.collectPlayers();
        this.scheduledTask = new ItemRemovalRunnable(this.plugin, this.players);
        this.scheduledTask.runTaskTimer(this.plugin, 0, 20L * this.delay);
    }

}

enum RemoveMode {Single, Slot}
