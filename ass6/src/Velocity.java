/**
 * @author Maor Bokobza
 */
//Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
    // fields
    private double dx;
    private double dy;

    /**
     * @param dx change in x value.
     * @param dy change in y value.
     */
// constructor
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }


    /**
     * @param p the point we want to move.
     * @return movedPoint the point after being moved.
     */
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        Point movedPoint = new Point(p.getX() + dx, p.getY() + dy);
        return movedPoint;
    }
    /**
     * @param angle the angle in which the ball moves.
     * @param speed the speed in which the ball moves in this angle.
     * @return new Velocity(dx, dy) the new velocity with
     * changes in x and y values.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.PI * angle / 180;
        double dx = speed * Math.sin(angle);
        double dy = speed * Math.cos(angle);
        return new Velocity(dx, dy);
    }
    /**
     *
     * @return dx
     */
    public double getDx() {
        return dx;
    }
    /**
     *
     * @return dy
     */
    public double getDy() {
        return dy;
    }
    /**
     *
     * @param dx1 var dx.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }
    /**
     *
     * @param dy1 var dy.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }
}