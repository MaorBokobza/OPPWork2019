import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maor Bokobza.
 */
public class SpriteCollection {
    private ArrayList<Sprite> listOfSprites;

    /**
     * * constructor.
     */
    public SpriteCollection() {
        this.listOfSprites = new ArrayList<>();
    }

    /**
     * @return listOfSprites a list that contains objects that are sprites.
     */
    public List<Sprite> getSpriteList() {
        return listOfSprites;
    }

    /**
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        listOfSprites.add(s);
    }

    /**
     * @param s b
     */
    public void removeSprite(Sprite s) {
        listOfSprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     **/
    public void notifyAllTimePassed() {
        if (listOfSprites.size() > 0) {
            for (int i = listOfSprites.size() - 1; i >= 0; i--) {
                listOfSprites.get(i).timePassed();
            }
        }
    }

    // call drawOn(d) on all sprites.

    /**
     * @param d drawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        if (listOfSprites.size() > 0) {
            for (Sprite s : listOfSprites) {
                s.drawOn(d);
            }
        }
    }
}