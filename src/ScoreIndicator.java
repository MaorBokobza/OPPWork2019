import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Maor Bokobza
 */
public class ScoreIndicator implements Sprite {
    private int x;
    private Counter score;

    /**
     * @param score score of a player.
     * @param x     x.
     */
    public ScoreIndicator(Counter score, int x) {
        this.score = score;
        this.x = x;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(x,
                17,
                "Score: " + String.valueOf(score.getValue()),
                20);
    }

    /**
     * @param gameLevel the level of the game.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    @Override
    public void timePassed() {

    }
}
