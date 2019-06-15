import biuoop.DrawSurface;

/**
 * interfacee Sprite.
 */
public interface Sprite {
    // draw the sprite to the screen

    /**
     * @param d drawn surface
     */
    void drawOn(DrawSurface d);
    // notify the sprite that time has passed

    /**
     * time passed func.
     */
    void timePassed();

    /**
     * @param gameLevel gamelevel
     */
    void addToGame(GameLevel gameLevel);
}
