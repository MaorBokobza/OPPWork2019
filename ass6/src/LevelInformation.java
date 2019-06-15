import java.util.List;

/**
 * @author Maor Bokobza
 */
public interface LevelInformation {
    /**
     *
     * @return
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     *
     * @return
     */
    List<Velocity> initialBallVelocities();

    /**
     *
     * @return
     */
    List<Point> initialBallPoints();

    /**
     *
     * @return
     */
    int paddleSpeed();
    /**
     *
     * @return
     */
    int paddleWidth();

    /**
     *
     * @return
     */
    int paddleX();

    /**
     *
     * @return
     */
    int paddleY();
    // the level name will be displayed at the top of the screen.

    /**
     *
     * @return
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     *
     * @return
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     *
     * @return
     */
    List<Block> blocks();

    /**
     *
     * @return
     */
    List<LineDraw> lines();

    /**
     *
     * @return
     */
    List<CircleDraw> circles();

    /**
     *
     * @return
     */


    /**
     *
     * @return
     */
    List<RectangleDraw> rectangles();


    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    /**
     *
     * @return
     */
    int numberOfBlocksToRemove();
}