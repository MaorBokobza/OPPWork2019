import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * @author Maor Bokobza.
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle rec;
    private Color color;
    private int leftBorder;
    private int rightBorder;

    /**
     * @param rectangle      rectangle
     * @param color          color
     * @param keyboardSensor keyboard sensor from GUI
     * @param left           left border
     * @param right          right border
     */

    public Paddle(Rectangle rectangle, Color color, KeyboardSensor keyboardSensor, int left, int right) {
        this.rec = rectangle;
        this.color = color;
        this.keyboard = keyboardSensor;
        this.leftBorder = left;
        this.rightBorder = right;
    }

    /**
     * the paddle will move to the left.
     */
    public void moveLeft() {
        if (rec.getUpperLeft().getX() - 5 < leftBorder) {
            rec.getUpperLeft().setX(leftBorder);
        } else {
            rec.getUpperLeft().setX(rec.getUpperLeft().getX() - 5);
        }

    }

    /**
     * the paddle will move to the right.
     */
    public void moveRight() {
        if (rec.getUpperLeft().getX() + rec.getWidth() + 5 > rightBorder) {
            rec.getUpperLeft().setX(rightBorder - rec.getWidth());
        } else {
            rec.getUpperLeft().setX(rec.getUpperLeft().getX() + 5);
        }
    }

    // Sprite

    /**
     * check if the "left" or "right" keys are pressed,
     * and if so move it accordingly.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) && keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            return;
        } else if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();

        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * @param d drawn surface.
     */
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
    }

    // Collidable

    /**
     * @return rec rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rec;
    }

    /**
     * @param hitter the ball that is hitting this paddle
     * @param collisionPoint  collision point.
     * @param currentVelocity the current velocity.
     * @return Velocity.fromAngleAndSpeed(60 - 180,
     * Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
     *  + Math.pow(currentVelocity.getDy(), 2)))
     * or Velocity.fromAngleAndSpeed(30 - 180,
     * Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
     *  + Math.pow(currentVelocity.getDy(), 2)))
     * or  new Velocity(currentVelocity.getDx(), currentVelocity.getDy())
     * or elocity.fromAngleAndSpeed(-30 - 180,
     * Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
     *  + Math.pow(currentVelocity.getDy(), 2)))
     * or Velocity.fromAngleAndSpeed(-60 - 180,
     * Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
     *  + Math.pow(currentVelocity.getDy(), 2)))
     * the new velocity with an angle
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        int zoneNumber = 5;
        if (collisionPoint.getY() + rec.getHeight() / 2 >= rec.getUpperLeft().getY()
                || collisionPoint.getY() == rec.getUpperLeft().getY()
                + rec.getHeight()) {
            for (int zone = 0; zone < zoneNumber; zone++) {
                // if we are in zone number <zone>
                if (collisionPoint.getX() <= rec.getUpperLeft().getX()
                        + (zone + 1) * rec.getWidth() / zoneNumber
                        && collisionPoint.getX() >= rec.getUpperLeft().getX()
                        + (zone) * rec.getWidth() / zoneNumber) {
                    if (zone == 0) {
                        return Velocity.fromAngleAndSpeed(60 - 180,
                                Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                                        + Math.pow(currentVelocity.getDy(), 2)));
                    } else if (zone == 1) {
                        return Velocity.fromAngleAndSpeed(30 - 180,
                                Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                                        + Math.pow(currentVelocity.getDy(), 2)));
                    } else if (zone == 2) {
                        currentVelocity.setDy(-currentVelocity.getDy());
                        return new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
                    } else if (zone == 3) {
                        return Velocity.fromAngleAndSpeed(-30 - 180,
                                Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2)));
                    } else if (zone == 4) {
                        return Velocity.fromAngleAndSpeed(-60 - 180,
                                Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2)));
                    }
                }
            }
        }
        if (rec.getUpperLeft().getY() >= collisionPoint.getY()
                || rec.getUpperLeft().getY() + rec.getHeight()
                <= collisionPoint.getY()) {
            currentVelocity.setDy(-currentVelocity.getDy());
        }
        return new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
    }

    // Add this paddle to the game.

    /**
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     *
     * @param g game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }
}