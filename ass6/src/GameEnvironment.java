import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
 public class GameEnvironment {
    private ArrayList<Collidable> collidables;

    /**
     *
     */
    GameEnvironment() {
        collidables = new ArrayList<>();
    }
    /**
     *
     * @param c collidable.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     *
     * @param c a collidable that we want to be removed.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     *
     * @param trajectory trajectory
     * @return null or
     * new CollisionInfo(closestIntersectionPoints.get(min.getKey()),
     * min.getKey())
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        HashMap<Collidable, Point>  closestIntersectionPoints = new HashMap<>();
        for (Collidable c : collidables) {
            if (trajectory.closestIntersectionToStartOfLine(
                    c.getCollisionRectangle()) != null) {
                closestIntersectionPoints.put(
                        c, trajectory.closestIntersectionToStartOfLine(
                        c.getCollisionRectangle()));
            }
        }
        // if map is empty
        if (closestIntersectionPoints.keySet().size() == 0) {
            return null;
        }
        // distance map
        HashMap<Collidable, Double> distances = new HashMap<>();
        for (Collidable c : closestIntersectionPoints.keySet()) {
            distances.put(c, closestIntersectionPoints.get(c).distance(
                    trajectory.start()));
        }
        // compute minimum
        Map.Entry<Collidable, Double> min = null;
        for (Map.Entry<Collidable, Double> entry : distances.entrySet()) {
            if (min == null || min.getValue() > entry.getValue()) {
                min = entry;
            }
        }

        return new CollisionInfo(closestIntersectionPoints.get(
                min.getKey()), min.getKey());
    }

}