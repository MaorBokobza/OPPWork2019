import java.awt.Color;
import biuoop.DrawSurface;

/**
 *@author Maor Bokobza.
 */
public class Ball implements Sprite {
    // fields
    private Point center;
    private int r;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * @param center the ball's center point.
     * @param r      the ball's radius.
     * @param color  the ball's color.
     * @param game  the game env.
     */
    // constructor
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment game) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(1, 1);
        this.gameEnvironment = game;

    }
    /**
     * @param x      the x value of the ball's center point.
     * @param y      the y value of the ball's center point.
     * @param radius the ball's radius.
     * @param color  the ball's color.
     */
    public Ball(int x, int y, int radius, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = radius;
        this.color = color;
    }

    /**
     * @return (int) this.center.getX() the x value of the ball's center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }


    /**
     * @return (int) this.center.getY() the y value of the ball's center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }


    /**
     * @return (int) this.r the radius's length.
     */
    public int getSize() {
        return (int) this.r;
    }


    /**
     * @return this.velocity the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * @return this.color the ball's color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    /**
     * @param myVelocity the ball's velocity
     */
    public void setVelocity(Velocity myVelocity) {
        this.velocity = myVelocity;
    }

    /**
     * @param dx the change in x value
     * @param dy the change in y value
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     *
     * @param gameEnv the game Environment
     */
    public void setGameEnvironment(GameEnvironment gameEnv) {
        this.gameEnvironment = gameEnv;
    }


    /**
     * this method makes the ball move and makes sure it stays in the screen.
     */
    public void moveOneStep() {
        Line trajectory = new Line(
                this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo collisionInfo =
                gameEnvironment.getClosestCollision(trajectory);
        // if a collision won't happen
        if (collisionInfo == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        Point collisionPoint = collisionInfo.collisionPoint();
        Collidable collidable = collisionInfo.collisionObject();
        if (this.velocity.getDx() > 0) {
            this.center.setX(collisionPoint.getX() - 1);
        } else {
            this.center.setX(collisionPoint.getX() + 1);
        }
        if (this.velocity.getDy() > 0) {
            this.center.setY(collisionPoint.getY() - 3);
        } else {
            this.center.setY(collisionPoint.getY() + 3);
        }
        this.velocity = collidable.hit(this, center, this.velocity);
    }

    /**
     * @param surface the surface of the ball
     */
    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(Math.round(this.getX()),
                    Math.round(this.getY()),
                    Math.round(this.getSize()));
        surface.setColor(Color.BLACK);
        surface.drawCircle(Math.round(this.getX()),
                Math.round(this.getY()),
                Math.round(this.getSize()));
    }

    /**
     * timePassed func.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     *
     * @param gameLevel a gameLevel.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.getBallsRemaining().increase(1);
    }

    /**
     *
     * @param gameLevel sad
     */
    void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}