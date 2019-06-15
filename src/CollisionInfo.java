/**
 *
 */
public class CollisionInfo {
    private Point point;
    private Collidable collidable;

    /**
     * @param point      point
     * @param collidable collidable
     */
    CollisionInfo(Point point, Collidable collidable) {
        this.point = point;
        this.collidable = collidable;
    }

    /**
     * @return point the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return point;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return collidable;
    }
}
