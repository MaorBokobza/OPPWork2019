import biuoop.DialogManager;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Maor Bokobza
 */
public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;
    private HighScoresTable highScoreTable;
    private ScoreInfo scoreInfo;
    private DialogManager dialogManager;

    /**
     * @param ar  animation runner
     * @param ks  keyboard
     * @param gui gui
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui, DialogManager dialogManager, HighScoresTable highScoresTable) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        this.gui = gui;
        this.highScoreTable = highScoresTable;
        this.dialogManager = dialogManager;
    }

    /**
     * @param levels levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        // ...
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor,
                    this.animationRunner, this.gui);
            level.initialize();
            while (level.getBlocksRemaining().getValue() > 0
                    && level.getLivesRemaining().getValue() > 0) {
                level.playOneTurn();
            }

            if (level.getLivesRemaining().getValue() == 0) {
                break;
            }

            //if (highScoreTable.getSize() > 10) {
                String name = dialogManager.showQuestionDialog("Enter Name", "What is your name?", "");
                scoreInfo = new ScoreInfo(name, level.getScore().getValue());
                highScoreTable.add(scoreInfo);
                try {
                    highScoreTable.save(new File("highscores"));
                } catch (IOException e) {
                    System.err.println("Failed presenting the high score");
                    e.printStackTrace(System.err);
                }
         //   }


        }
        this.animationRunner.run(new EndScreen(this.keyboardSensor,
                GameLevel.getScore(), true, this.gui));
    }
}