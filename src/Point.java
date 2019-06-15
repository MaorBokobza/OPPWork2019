/**
 * @author Maor Bokobza
 */
public class Point {
    // fields:
    private double x;
    private double y;

    /**
     * @param x the x value of the point.
     * @param y the y value of the point.
     */
    // constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other second point
     * @return distance the distance between the two points
     */
    // distance -- return the distance of this point to the other point
    public double distance(Point other) {
        double distance = Math.sqrt((this.x - other.x) * (this.x - other.x)
                + (this.y - other.y) * (this.y - other.y));
        return distance;
    }

    /**
     * @param other second point
     * @return true or false
     */
    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        if ((this.x == other.x) && (this.y == other.y)) {
            return true;
        }
        return false;
    }

    /**
     * @return this.x the x value of this point
     */
    // Return the x and y values of this point
    public double getX() {
        return this.x;
    }

    /**
     * @return this.y the y value of this point
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param pointX the x value of a point
     */
    public void setX(double pointX) {
        this.x = pointX;
    }

    /**
     * @param pointY the y value of a point
     */
    public void setY(double pointY) {
        this.y = pointY;
    }

    /**
     * @param other second point
     * @return (this.x * other.y - other.x * this.y)
     */
    public double crossProduct(Point other) {
        return (this.x * other.y - other.x * this.y);
    }
}