// a BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
// of the number of blocks that remain.

/**
 * @author Maor Bokobza
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     *
     * @param gameLevel the gameLevel.
     * @param removedBlocks a counter that counts the number of blocks
     *                      that have been removed.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    // Blocks that are hit and reach 0 hit-points should be removed
    // from the gameLevel. Remember to remove this listener from the block
    // that is being removed from the gameLevel.

    /**
     *
     * @param beingHit a block that is being hit.
     * @param hitter the ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() == 0) {
            beingHit.removeFromGame(gameLevel);
            beingHit.removeHitListener(this);
            remainingBlocks.decrease(1);
        }
    }
}
