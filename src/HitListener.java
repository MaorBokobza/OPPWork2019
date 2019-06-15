/**
 * @author Maor Bokobza
 */
public interface HitListener {
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.

    /**
     * @param beingHit a block that is being hit.
     * @param hitter   a ball that hits the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}