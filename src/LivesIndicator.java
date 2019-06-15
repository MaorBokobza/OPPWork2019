import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Maor Bokobza.
 */
public class LivesIndicator implements Sprite {
    private int x;
    private Counter score;

    /**
     * @param score score
     * @param x     sakj
     */
    public LivesIndicator(Counter score, int x) {
        this.score = score;
        this.x = x;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(x,
                17,
                "Lives: " + String.valueOf(score.getValue()),
                20);
    }

    /**
     * @param gameLevel 874
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    @Override
    public void timePassed() {

    }
}
