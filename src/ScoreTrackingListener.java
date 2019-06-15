/**
 * @author Maor Bokobza
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * @param scoreCounter a counter that counts the player's score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * @param beingHit a block that is being hit.
     * @param hitter   a ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        // hitting a block adds 5 to the score
        currentScore.increase(5);
        if (beingHit.getHitPoints() == 0) {
            currentScore.increase(10);
        }

    }
}