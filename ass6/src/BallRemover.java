// a BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
// of the number of blocks that remain.

/**
 * @author Maor Bokobza
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     *
     * @param gameLevel the gameLevel.
     * @param remainingBalls the number of balls that are still on screen.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    // Blocks that are hit and reach 0 hit-points should be removed
    // from the gameLevel. Remember to remove this listener from the block
    // that is being removed from the gameLevel.

    /**
     *
     * @param beingHit a block that is being hit by one of the balls
     * @param hitter the hitting ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(1);
        if(remainingBalls.getValue()==0)
            gameLevel.decreaselive();
    }
}
