package tech.lapis0875.randomsurvival;

import net.kyori.adventure.text.format.TextColor;

public final class Constants {
    public static final String PLUGIN_NAME = "RandomSurvival";
    public static final class Commands {
        public static final String RS = "rs";
        public static final String OPT_START = "start";
        public static final String OPT_STOP = "stop";
    }
    public static final class Games {
        public static final String SWAP_LOCATION = "SwapLocation";
        public static final String ITEM_REMOVAL = "ItemRemoval";
        public static final String RECIPE_RANDOMNESS = "RecipeRandomness";
    }
    public static final int DEFAULT_DELAY = 60;
    public static final TextColor COLOR_GREEN = TextColor.color(171, 242, 0);
}
