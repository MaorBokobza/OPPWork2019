/**
 * @author Maor Bokobza/
 */
public interface HitNotifier {
    // Add hl as a listener to hit events.

    /**
     * @param hl an object that will be notified of hit events, is registered
     *           in this method.
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.

    /**
     * @param hl an object that we want to remove from the list of listeners
     *           to hit events, is removed in this method.
     */
    void removeHitListener(HitListener hl);
}