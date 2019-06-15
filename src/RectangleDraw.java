import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maor Bokobza
 */
class RectangleDraw implements Sprite {
    //fields
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;

    /**
     * @param upperLeft1 the start point of the rectangle, located
     *                   on the upper left.
     * @param width1     the rectangle's width.
     * @param height1    the rectangle's height.
     * @param color    the rectangle's color.
     */
    // Create a new rectangle with location and width/height.
    RectangleDraw(Point upperLeft1, double width1, double height1, Color color) {
        this.upperLeft = upperLeft1;
        this.width = width1;
        this.height = height1;
        this.color = color;
    }

    /**
     * @param line a line.
     * @return list.
     */
    // Return a (possibly empty) List of intersection points
    // with the specified line.
    public List<Point> intersectionPoints(Line line) {
        // generate all four points
        Point upperRight = new Point(upperLeft.getX() + this.getWidth(),
                upperLeft.getY());
        Point downLeft = new Point(upperLeft.getX(),
                upperLeft.getY() + this.getHeight());
        Point downRight = new Point(upperLeft.getX() + this.getWidth(),
                getUpperLeft().getY() + this.getHeight());
        Line[] lines = {
                new Line(upperLeft, upperRight),
                new Line(downLeft, downRight),
                new Line(upperLeft, downLeft),
                new Line(upperRight, downRight),
        };
        Point[] intersectionPoints = {
                lines[0].intersectionWith(line),
                lines[1].intersectionWith(line),
                lines[2].intersectionWith(line),
                lines[3].intersectionWith(line),
        };

        ArrayList<Point> list = new ArrayList<Point>();
        for (int i = 0; i < 4; i++) {
            if (intersectionPoints[i] != null) {
                list.add(intersectionPoints[i]);
            }
        }
        return list;
    }

    /**
     * @return this.getWidth() the rectangle's width.
     */
    // Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }

    /**
     * @return this.getHeight() the rectangle's height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return this.getUpperLeft() the start point of the rectangle, which is
     * located on the its upper left.
     */
    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.getHeight(), (int) this.getWidth());
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.getRectanglesRemaining();
    }
}