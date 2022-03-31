package tech.lapis0875.randomsurvival.games;

import javax.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class RSGameManager {
    private static RSGameManager instance;
    private final Map<Class<? extends RSGame>,RSGame> gameMap;

    private RSGameManager() {
        this.gameMap = new HashMap<>();
    }

    static {
        // Create singleton instance on class creation phase. * ONLY ONE INSTANCE
        RSGameManager.instance = new RSGameManager();
    }

    public static RSGameManager getInstance() {
        return RSGameManager.instance;
    }

    @Nullable
    public <T extends RSGame> T getGameInstance(Class<T> gameClass) {
        return (T) this.gameMap.get(gameClass);
    }

    /*
    Create new RSGame instance with default constructor (no args)
    User need to manually set values by setA(value) ex) SwapLocationGame().setDelay(5);
     */
    public <T extends RSGame> T createGameInstance(Class<T> gameClass) {
        try {
            Constructor<? extends RSGame> gameConstructor = gameClass.getConstructor();
            try {
                T gameInstance = (T) gameConstructor.newInstance();
                this.gameMap.put(gameClass, gameInstance);
                return gameInstance;
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException ignored) {}
        } catch (NoSuchMethodException ignored) {}
        return null;
    }

    public void stopInstance(Class<? extends RSGame> gameClass) {
        RSGame gameInstance = this.gameMap.get(gameClass);
        if (gameInstance != null) {
            gameInstance.stop();
            this.gameMap.remove(gameClass);
        }
    }

}
