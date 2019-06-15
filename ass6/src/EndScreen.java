import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    private boolean win;
    /**
     *
     * @param k keyboard sensor
     */
    public EndScreen(KeyboardSensor k,Counter score,boolean win) {
        this.keyboard = k;
        this.win=win;
        this.stop = false;
        this.score=score;
    }

    /**
     *
     * @param d draw surface
     */
    public void doOneFrame(DrawSurface d) {
        if(win==false) {
            d.drawText(10, d.getHeight() / 2, "Game Over! Your score is:" + score.getValue(), 32);
        }
        if(win==true) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is" + score.getValue(), 32);

        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     *
     * @return this.stop stop the game
     */
    public boolean shouldStop() {
        return this.stop;
    }
}