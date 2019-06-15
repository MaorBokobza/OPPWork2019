import java.util.List;
import java.util.Random;

/**
 * @author Maor Bokobza
 */
public class Line {
    // fields
    private Point start;
    private Point end;

    /**
     * @param start the start point of a line.
     * @param end   the end point of a line.
     */
    // constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @param x1 x value of start point
     * @param y1 y value of start point
     * @param x2 x value of end point
     * @param y2 y value of end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return this.start.distance(this.end) the distance
     * between the two points of
     * start and end which is the length of the line
     */
    // Return the length of the line
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * @return new Point(middleX, middleY) the middle point of the line
     */
    // Returns the middle point of the line
    public Point middle() {
        double middleX;
        double middleY;
        middleX = ((this.start().getX() + this.end().getX()) / 2);
        middleY = ((this.start().getY() + this.end().getY()) / 2);
        return new Point(middleX, middleY);
    }

    /**
     * @return this.start the start point of a line
     */
    // Returns the start point of the line
    public Point start() {
        return this.start;
    }

    /**
     * @return this.end the end point of a line
     */
    // Returns the end point of the line
    public Point end() {
        return this.end;
    }

    /***************************************************
     * I took some inspiration from this blog post about the strategy for
     * calculating the intersection point hope this is okay :)
     * https://martin-thoma.com/how-to-check-if-two-line-segments-intersect/
     ****************************************************/

    /**
     * @param other second line
     * @return (myBox[0].getX () <= otherBox[1].getX() && myBox[1].getX() >=
     * otherBox[0].getX() && myBox[0].getY() <= otherBox[1].getY() &&
     * myBox[1].getY() >= otherBox[0].getY()) which is true or false, if the
     * "boxes" around the lines intersect
     */
    // check if bounding boxes around the lines intersect
    private boolean doBoundingBoxesIntersect(Line other) {
        Point[] myBox = new Point[2];
        Point[] otherBox = new Point[2];
        // calculate bounding boxes for both lines
        myBox[0] = new Point(Math.min(this.start.getX(), this.end.getX()),
                Math.min(this.start.getY(), this.end.getY()));
        myBox[1] = new Point(Math.max(this.start.getX(), this.end.getX()),
                Math.max(this.start.getY(), this.end.getY()));
        otherBox[0] = new Point(Math.min(other.start.getX(), other.end.getX()),
                Math.min(other.start.getY(), other.end.getY()));
        otherBox[1] = new Point(Math.max(other.start.getX(), other.end.getX()),
                Math.max(other.start.getY(), other.end.getY()));
        // check whether bounding boxes intersect
        return (myBox[0].getX() <= otherBox[1].getX()
                && myBox[1].getX() >= otherBox[0].getX()
                && myBox[0].getY() <= otherBox[1].getY()
                && myBox[1].getY() >= otherBox[0].getY());
    }

    /**
     * @param point a point, we want to check if it's on the line
     * @return Math.abs(r) < 0.00001 true or false,
     * is the absolute value of the
     * radius smaller than 0.00001
     */
    // check if given point is on line
    private boolean isPointOnLine(Point point) {
        // Move the image, so that this.start is on (0, 0)
        double r;
        Line tempLine = new Line(new Point(0, 0),
                new Point(this.end.getX() - this.start.getX(),
                        this.end.getY() - this.start.getY()));
        Point tempPoint = new Point(point.getX() - this.start.getX(),
                point.getY() - this.start.getY());
        r = tempLine.end.crossProduct(tempPoint);
        // double comparisons
        return Math.abs(r) < 0.00001;
    }

    /**
     * @param point a point, we want to check if it's
     *              on the right side of the line
     * @return tempLine.end.crossProduct(tempPoint) < 0
     * which is true or false.
     */
    // check if given point is right of line
    private boolean isPointRightOfLine(Point point) {
        // Move the image, so that a.first is on (0, 0)
        Line tempLine = new Line(new Point(0, 0),
                new Point(this.end.getX() - this.start.getX(),
                        this.end.getY() - this.start.getY()));
        Point tempPoint = new Point(point.getX() - this.start.getX(),
                point.getY() - this.start.getY());
        return tempLine.end.crossProduct(tempPoint) < 0;
    }

    /**
     * @param other second line,
     * @return this.isPointOnLine(other.start) ||
     * this.isPointOnLine(other.end)
     * || (this.isPointRightOfLine(other.start)
     * ^ this.isPointRightOfLine(other.end)) which is true or false,
     * if the first line touches or crosses segment.
     */
    // check if first line touches or crosses segment
    private boolean lineSegmentTouchesOrCrossesLine(Line other) {
        return this.isPointOnLine(other.start) || this.isPointOnLine(other.end)
                || (this.isPointRightOfLine(other.start)
                ^ this.isPointRightOfLine(other.end));
    }

    /**
     * @param other second line, we want to check if the lines intersect
     * @return this.doBoundingBoxesIntersect(other)
     * && this.lineSegmentTouchesOrCrossesLine(other)
     * && other.lineSegmentTouchesOrCrossesLine(this)
     * which is true or false- if the lines intersect or not
     */
    // Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        return this.doBoundingBoxesIntersect(other)
                && this.lineSegmentTouchesOrCrossesLine(other)
                && other.lineSegmentTouchesOrCrossesLine(this);
    }

    /**
     * @param other second line, we want to check if
     *              it intersects with the first one
     * @return null or new Point((b2 * c1 - b1 * c2) / delta,
     * (a1 * c2 - a2 * c1) / delta) which is the intersection point
     */
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        if (!this.isIntersecting(other)) {
            return null;
        }

        double a1 = this.end.getY() - this.start.getY();
        double b1 = this.start.getX() - this.end.getX();
        double c1 = a1 * this.start.getX() + b1 * this.start.getY();
        double a2 = other.end.getY() - other.start.getY();
        double b2 = other.start.getX() - other.end.getX();
        double c2 = a2 * other.start.getX() + b2 * other.start.getY();
        double delta = a1 * b2 - a2 * b1;
        return new Point((b2 * c1 - b1 * c2) / delta,
                (a1 * c2 - a2 * c1) / delta);
    }

    /**
     * @param other second line, we want to check if it equals
     *              to the first one.
     * @return true or false true if they are equal, and false if they aren't.
     */
    public boolean equals(Line other) {
        if ((this.start == other.start && this.end == other.end)
                || (this.end == other.start && this.start == other.end)) {
            return true;
        }
        return false;
    }

    /**
     * @return line the line we want generate randomly.
     */
    public static Line generateRandomLine() {
        Random rand = new Random();
        Line line = new Line((int) (rand.nextInt(400) + 1),
                (int) (rand.nextInt(300) + 1),
                (int) (rand.nextInt(400) + 1),
                (int) (rand.nextInt(300) + 1));
        return line;
    }

    /**
     *
     * @param rect rectangle
     * @return null
     */

        // If this line does not intersect with the rectangle, return null.
        // Otherwise, return the closest intersection point to the
        // start of the line.
        public Point closestIntersectionToStartOfLine(Rectangle rect) {
            List<Point> intersectionList = rect.intersectionPoints(this);
            if (intersectionList.size() == 0) {
                return null;
            }
            Point temp = intersectionList.get(0);
            double dist = this.start.distance(temp);

            for (int i = 0; i < intersectionList.size(); i++) {
                if (this.start.distance(intersectionList.get(i)) < dist) {
                    dist = this.start.distance(intersectionList.get(i));
                    temp = intersectionList.get(i);
                }
            }
            return temp;
        }
}
