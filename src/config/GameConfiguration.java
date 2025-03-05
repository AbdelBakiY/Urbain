package config;

public class GameConfiguration {
    public static final int BLOCK_SIZE = 20;

    // Mise à jour pour correspondre à une grille de 50x30 avec BLOCK_SIZE = 20
    public static final int WINDOW_WIDTH = 50 * BLOCK_SIZE; // 1000
    public static final int WINDOW_HEIGHT = 30 * BLOCK_SIZE; // 600

    public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE; // 50
    public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE; // 30

    public static final int GAME_SPEED = 0;
    
    
   public static final int DUREJOURNEEREELPARSECOND = 180; // 3 minutes en secondes
   public static final int NB_HEURES = 24;
   public static final int INTERVALLES_HEURES = DUREJOURNEEREELPARSECOND / NB_HEURES;
}
