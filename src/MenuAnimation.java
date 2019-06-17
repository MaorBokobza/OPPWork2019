import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;
import java.util.List;

public class MenuAnimation<T> implements Menu<T> {
    private AnimationRunner runner;
    private KeyboardSensor keyboardSensor;
    private String title;
    private List<T> menuReturnValues;
    private List<String> menuItemNames;
    private List<String> menuItemKeys;
    private T status;

    public MenuAnimation(String title, AnimationRunner runner, KeyboardSensor keyboardSensor) {
        this.title = title;
        this.runner = runner;
        this.keyboardSensor = keyboardSensor;
    }

    public void addSelection(String key, String message, T returnVal) {
        menuItemKeys.add(key);
        menuItemNames.add(message);
        menuReturnValues.add(returnVal);
    }

    @Override
    public T getStatus() {
        return status;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        d.drawText(51, 50, title, 32);
        d.drawText(49, 50, title, 32);
        d.drawText(50, 51, title, 32);
        d.drawText(50, 49, title, 32);
        d.setColor(Color.YELLOW);
        d.drawText(50, 50, title, 32);
        for (int i = 0; i < menuItemNames.size(); i++) {
            int optionX = 100;
            int optionY = 120 + i * 40;
            String optionText = "(" + (String) menuItemKeys.get(i) + ") " + (String) menuItemNames.get(i);

            d.setColor(Color.BLACK);
            d.drawText(optionX + 1, optionY, optionText, 24);
            d.drawText(optionX - 1, optionY, optionText, 24);
            d.drawText(optionX, optionY + 1, optionText, 24);
            d.drawText(optionX, optionY - 1, optionText, 24);

            d.setColor(Color.GREEN);
            d.drawText(optionX, optionY, optionText, 24);
        }

    }

    public boolean shouldStop() {
        return status != null;
    }


}
