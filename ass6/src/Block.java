
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maor Bokobza.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rec;
    private Color color;
    private Integer hitPoints;
    private ArrayList<HitListener> hitListeners;
    /**
     *
     * @param rectangle rectangle.
     * @param color color of the rectangle
     * @param hp hit points
     * @return
     */
    public Block(Rectangle rectangle, Color color, int hp) {
        this.rec = rectangle;
        this.color = color;
        this.hitPoints = hp;
        hitListeners = new ArrayList<>();
    }

    /**
     *
     * @return hitPoints points that were hit
     */
    public int getHitPoints() {
        return hitPoints;
    }
    /**
     *
     * @param listener an object that wants to be notified of hit events,
     *                 is registered in this method.
     */
    @Override
    public void addHitListener(HitListener listener) {
        hitListeners.add(listener);
    }

    /**
     *
     * @param listener an object from the list of listeners to hit events,
     *                 is removed in this method.
     */
    @Override
    public void removeHitListener(HitListener listener) {
        hitListeners.remove(listener);
    }

    /**
     *
     * @param hitter sada
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     *
     * @return rec rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rec;
    }

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * @param hitter the ball that hit this block
     * @param collisionPoint the collision point.
     * @param  currentVelocity the current velocity.
     * @return  new Velocity(currentVelocity.getDx(), currentVelocity.getDy()).
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (this.hitPoints > 0) {
            this.hitPoints -= 1;
        }
        if (rec.getUpperLeft().getX() >= collisionPoint.getX()
           || rec.getUpperLeft().getX() + rec.getWidth()
                <= collisionPoint.getX()) {
            currentVelocity.setDx(-currentVelocity.getDx());
        }
        if (rec.getUpperLeft().getY() >= collisionPoint.getY()
            || rec.getUpperLeft().getY() + rec.getHeight()
                <= collisionPoint.getY()) {
            currentVelocity.setDy(-currentVelocity.getDy());
        }
        notifyHit(hitter);
        return new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
    }

    /**
     *
     * @param gameLevel a gameLevel.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
        gameLevel.getBlocksRemaining().increase(1);
    }

    @Override
    public void drawOn(DrawSurface d) {
        // border of rectangle

        d.setColor(Color.BLACK);
        d.drawRectangle((int) rec.getUpperLeft().getX(),
                (int) rec.getUpperLeft().getY(),
                (int) rec.getWidth(),
                (int) rec.getHeight());

        d.setColor(color);
        d.fillRectangle((int) rec.getUpperLeft().getX(),
                        (int) rec.getUpperLeft().getY(),
                        (int) rec.getWidth(),
                        (int) rec.getHeight());
        d.setColor(Color.BLACK);
        if (hitPoints > 0) {
            d.drawText((int) (rec.getUpperLeft().getX() + (rec.getWidth() - 8) / 2),
                    (int) (rec.getUpperLeft().getY() + (rec.getHeight() + 11) / 2),
                    hitPoints.toString(),
                    20);
        }
    }

    @Override
    public void timePassed() {

    }

    /**
     *
     * @param g s
     */
    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }
}
