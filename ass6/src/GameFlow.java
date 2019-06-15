import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;

    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui)
    {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        this.gui=gui;
    }

    public void runLevels(List<LevelInformation> levels) {
        // ...
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo , this.keyboardSensor, this.animationRunner,this.gui);

            level.initialize();


            while (level.getBlocksRemaining().getValue() > 0 && level.getLivesRemaining().getValue() > 0) {
                level.playOneTurn();
            }

            if (level.getLivesRemaining().getValue() == 0) {
                break;
            }


        }
        this.animationRunner.run(new EndScreen(this.keyboardSensor, GameLevel.getScore(),true));
    }
}