import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Maor Bokobza.
 */
public class LineDraw implements Sprite {
    private Color color;
    private Point start;
    private Point end;

    /**
     * @param start start point of a line
     * @param end   end point of a line
     * @param color color
     */
    public LineDraw(Point start, Point end, Color color) {

        this.start = start;
        this.end = end;
        this.color = color;
    }

    /**
     * @param x1    x value of start point
     * @param y1    y value of start point
     * @param x2    x value of end point
     * @param y2    y value of end point
     * @param color color
     */
    public LineDraw(double x1, double y1, double x2, double y2, Color color) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.color = color;
    }

    /**
     *
     * @return hitPoints points that were hit
     */
    /**
     * @param gameLevel a gameLevel.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.drawLine((int) start.getX(), (int) start.getY(),
                (int) end.getX(), (int) end.getY());
    }

    @Override
    public void timePassed() {
    }

    /**
     * @param g gameLevel.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
