import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 *
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private GUI gui;
    private Counter score;
    private boolean win;

    /**
     *
     * @param k KeyboardSensor parameter.
     * @param score player's score.
     * @param win boolean param, true if player won and false if player lost.
     * @param gui gui.
     */
    public EndScreen(KeyboardSensor k, Counter score, boolean win, GUI gui) {
        this.keyboard = k;
        this.win = win;
        this.gui = gui;
        this.score = score;

    }

    /**
     * @param d draw surface
     */
    public void doOneFrame(DrawSurface d) {
        if (!win) {
            d.drawText(10, d.getHeight() / 2, "Game Over! Your score is: " + score.getValue(), 32);
        }
        if (win) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 32);

        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.gui.close();
        }
    }

    /**
     * @return this.stop stop the game
     */
    public boolean shouldStop() {
        return false;
    }
}