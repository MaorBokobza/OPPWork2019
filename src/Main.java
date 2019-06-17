import biuoop.DialogManager;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maor Bokobza.
 */
public class Main {
    /**
     * @param args arguments.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("My cool game", 600, 500);
        DialogManager dialog = gui.getDialogManager();
        HighScoresTable highScoresTable = new HighScoresTable(10);
        HighScoresAnimation highScoresAnimation = new HighScoresAnimation(highScoresTable);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        AnimationRunner animationRunner = new AnimationRunner(gui);
        Menu<Task> menu = new MenuAnimation<>("Menu Title", animationRunner, keyboardSensor);
        args = new String[]{"2", "3"};
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor, gui, dialog, highScoresTable);
// the parameters to addSelection are:
// key to wait for, line to print, what to return
        //menu.addSelection("s", "Start Game", gameFlow);
//        menu.addSelection("h", "High Scores", new ShowHiScoresTask(animationRunner,highScoresAnimation));
        //menu.addSelection("e", "Exit", );



        List<LevelInformation> levels = new ArrayList<>();

        Testing testing = new Testing();
        testing.getRank();

        for (int i = 0; i < args.length; i++) {
            if (args[i] == "1") {
                levels.add(new DirectHit());
            } else if (args[i] == "2") {
                levels.add(new WideEasy());
            } else if (args[i] == "3") {
                levels.add(new Green3());
            } else if (args[i] == "4") {
                levels.add(new FinalFour());
            }
        }
        gameFlow.runLevels(levels);
    }
}