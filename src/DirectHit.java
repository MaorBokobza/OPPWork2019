import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Maor Bokobza.
 */
public class DirectHit implements LevelInformation {
    private static final int NUMBER_OF_BALLS = 1;
    private static final int PADDLE_SPEED = 100;
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_X = 270;
    private static final int PADDLE_Y = 460;
    private static final String LEVEL_NAME = "Direct Hit";
    private static final int NUMBER_OF_BALLS_TO_REMOVE = 1;
    private static Sprite background;

    /**
     * create background.
     */
    public DirectHit() {
        background = new Block(new Rectangle(new Point(0, 0), 600,
                500), Color.BLACK, -1);
    }

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocity = new ArrayList<>();
        Velocity velocity = new Velocity(0, 4);
        ballsVelocity.add(velocity);
        return ballsVelocity;
    }

    @Override
    public List<Point> initialBallPoints() {
        List<Point> ballsPoints = new ArrayList<>();
        Point point = new Point(300, 400);
        ballsPoints.add(point);
        return ballsPoints;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public int paddleX() {
        return PADDLE_X;
    }

    @Override
    public int paddleY() {
        return PADDLE_Y;
    }

    @Override
    public String levelName() {
        return LEVEL_NAME;
    }

    @Override
    public Sprite getBackground() {

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> listBlocks = new ArrayList<>();
        Block b1 = new Block(new Rectangle(new Point(295, 150), 30,
                30), Color.red, 1);
        listBlocks.add(b1);
        return listBlocks;
    }

    /**
     * @return listLines list of lines
     */
    public List<LineDraw> lines() {
        List<LineDraw> listLines = new ArrayList<>();
        LineDraw l1 = new LineDraw(350, 160, 450, 160, Color.blue);
        listLines.add(l1);
        LineDraw l2 = new LineDraw(170, 160, 270, 160, Color.blue);
        listLines.add(l2);
        LineDraw l3 = new LineDraw(310, 20, 310, 120, Color.blue);
        listLines.add(l3);
        LineDraw l4 = new LineDraw(310, 200, 310, 300, Color.blue);
        listLines.add(l4);
        return listLines;

    }

    /**
     * @return listCircle list of circles
     */
    public List<CircleDraw> circles() {
        List<CircleDraw> listCircle = new ArrayList<>();
        CircleDraw b1 = new CircleDraw(310, 160, 30, Color.BLUE);
        CircleDraw b2 = new CircleDraw(310, 160, 50, java.awt.Color.BLUE);
        CircleDraw b3 = new CircleDraw(310, 160, 80, Color.BLUE);
        listCircle.add(b1);
        listCircle.add(b2);
        listCircle.add(b3);
        return listCircle;
    }


    @Override
    public List<RectangleDraw> rectangles() {
        return null;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BALLS_TO_REMOVE;
    }
}
