import java.util.List;

/**
 * @author Maor Bokobza
 */
public interface LevelInformation {
    /**
     * @return numberOfBalls number of balls
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * @return initialBallVelocities initial velocity of a ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return initialBallPoints initial center point of a ball.
     */
    List<Point> initialBallPoints();

    /**
     * @return paddleSpeed paddle's speed.
     */
    int paddleSpeed();

    /**
     * @return paddleWidth paddle's width.
     */
    int paddleWidth();

    /**
     * @return paddleX x value of paddle.
     */
    int paddleX();

    /**
     * @return y value of paddle.
     */
    int paddleY();
    // the level name will be displayed at the top of the screen.

    /**
     * @return levelName level's name.
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     * @return getBackground background.
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * @return blocks() list of blocks.
     */
    List<Block> blocks();

    /**
     * @return lines() list of lines.
     */
    List<LineDraw> lines();

    /**
     * @return circles() list of circles.
     */
    List<CircleDraw> circles();

    /**
     * @return rectangles() list of rectangles.
     */
    List<RectangleDraw> rectangles();


    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * @return numberOfBlocksToRemove number of blocks to remove.
     */
    int numberOfBlocksToRemove();
}