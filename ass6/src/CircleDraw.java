import java.awt.Color;
import biuoop.DrawSurface;

/**
 *@author Maor Bokobza.
 */
public class CircleDraw implements Sprite {
    // fields
    private Point center;
    private int r;
    private Color color;
    private boolean fill=false;


    /**
     * @param center the ball's center point.
     * @param r      the ball's radius.
     * @param color  the ball's color.
     */
    // constructor
    public CircleDraw(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;

    }
    /**
     * @param x      the x value of the ball's center point.
     * @param y      the y value of the ball's center point.
     * @param radius the ball's radius.
     * @param color  the ball's color.
     */
    public CircleDraw(int x, int y, int radius, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = radius;
        this.color = color;
    }
    public CircleDraw(int x, int y, int radius, java.awt.Color color,boolean fill) {
        this.center = new Point(x, y);
        this.r = radius;
        this.color = color;
        this.fill = fill;
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
     * @return this.color the ball's color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }







    /**
     * @param surface the surface of the ball
     */
    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.drawCircle(Math.round(this.getX()),
                Math.round(this.getY()),
                Math.round(this.getSize()));
        if (fill) {
            surface.fillCircle(Math.round(this.getX()),
                    Math.round(this.getY()),
                    Math.round(this.getSize()));
        }
    }

    /**
     * timePassed func.
     */
    public void timePassed() {

    }

    /**
     *
     * @param gameLevel a gameLevel.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     *
     * @param gameLevel sad
     */
    void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}