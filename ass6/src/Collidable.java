/**
 *
 */
public interface Collidable {
    // Return the "collision shape" of the object.

    /**
     *
     * @return asd
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * @param hitter the ball that is hitting
     * @param collisionPoint collision point.
     * @param  currentVelocity the current velocity.
     * @return hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}