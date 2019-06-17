import biuoop.DrawSurface;

import java.awt.*;

/**
 * @author Maor Bokobza
 */
public class HighScoresAnimation implements Animation {
    /**
     * @param scores player's score and name.
     */
    private HighScoresTable highScoreTable;

    public HighScoresAnimation(HighScoresTable scores) {
        this.highScoreTable = scores;
    }

    @Override
    /**
     *
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        d.drawText(51, 50, "High Scores", 32);
        d.drawText(49, 50, "High Scores", 32);
        d.drawText(50, 51, "High Scores", 32);
        d.drawText(50, 49, "High Scores", 32);
        d.setColor(Color.YELLOW);
        d.drawText(50, 50, "High Scores", 32);
        d.setColor(Color.BLACK);
        d.drawText(101, 120, "ScoreInfo Name", 24);
        d.drawText(99, 120, "ScoreInfo Name", 24);
        d.drawText(100, 121, "ScoreInfo Name", 24);
        d.drawText(100, 119, "ScoreInfo Name", 24);
        d.setColor(Color.GREEN);
        d.drawText(100, 120, "ScoreInfo Name", 24);
        d.setColor(Color.BLACK);
        d.drawText(451, 120, "Score", 24);
        d.drawText(449, 120, "Score", 24);
        d.drawText(450, 121, "Score", 24);
        d.drawText(450, 119, "Score", 24);
        d.setColor(Color.GREEN);
        d.drawText(450, 120, "Score", 24);
        d.setColor(Color.BLACK);
        d.drawLine(100, 130, 700, 130);
        d.setColor(Color.GREEN);
        d.drawLine(100, 131, 700, 131);
        d.setColor(Color.BLACK);
        d.drawLine(100, 132, 700, 132);
        d.setColor(Color.BLACK);
        for (int i = 0; i < highScoreTable.size(); i++) {
            ScoreInfo player = highScoreTable.get(i);
            int nameX = 100;
            int scoreX = 450;
            int entryY = 170 + i * 40;
            d.setColor(Color.BLACK);
            d.drawText(nameX + 1, entryY, player.getName(), 24);
            d.drawText(nameX - 1, entryY, player.getName(), 24);
            d.drawText(nameX, entryY + 1, player.getName(), 24);
            d.drawText(nameX, entryY - 1, player.getName(), 24);
            d.setColor(Color.ORANGE);
            d.drawText(nameX, entryY, player.getName(), 24);
            d.setColor(Color.BLACK);
            d.drawText(scoreX + 1, entryY, "" + player.getScore(), 24);
            d.drawText(scoreX - 1, entryY, "" + player.getScore(), 24);
            d.drawText(scoreX, entryY + 1, "" + player.getScore(), 24);
            d.drawText(scoreX, entryY - 1, "" + player.getScore(), 24);

            d.setColor(Color.ORANGE);
            d.drawText(scoreX, entryY, "" + player.getScore(), 24);
        }
    }
    /**
     * @return false
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
