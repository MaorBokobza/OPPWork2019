import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Maor Bokobza.
 */
public class LevelNameIndicator implements Sprite {
    private String name;

    /**
     *
     * @param name the name of the game's level
     */
    public LevelNameIndicator(String name) {
       this.name = name;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(350,
                17,
                "Level Name: " + name,
                20);
    }

    /**
     *
     * @param gameLevel 874
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    @Override
    public void timePassed() {

    }
}
