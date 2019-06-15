import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 *
 */
public class CountdownAnimation implements Animation {
    private boolean stop;
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Sleeper sleeper;
    private int millisecondsPerFrame;
    private long startTime;
    /**
     *
     * @param numOfSeconds num of seconds
     * @param countFrom count from
     * @param gameScreen game screen
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.startTime = System.currentTimeMillis();
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        stop = false;
        this.sleeper = new Sleeper();
        this.millisecondsPerFrame = (int) (1000 * numOfSeconds / countFrom);
    }

    /**
     *
      * @param d draw surface
     */
    public void doOneFrame(DrawSurface d) {
        if (this.countFrom == -1) {
            this.stop = true;
            return;
        }
        gameScreen.drawAllOn(d);
        d.setColor(Color.WHITE);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2,
                String.valueOf(this.countFrom), 50);
        long usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
        if (milliSecondLeftToSleep > 0) {
            this.sleeper.sleepFor(milliSecondLeftToSleep);
            this.startTime = System.currentTimeMillis();
            this.countFrom -= 1;
        }

    }
    /**
     *
     * @return this.stop stop the game.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}