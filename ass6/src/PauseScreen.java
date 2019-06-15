import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     *
     * @param k keyboard sensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     *
     * @param d draw surface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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