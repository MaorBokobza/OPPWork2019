import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Maor Bokobza.
 */
public class Green3 implements LevelInformation {
    private static final int NUMBER_OF_BALLS = 2;
    private static final int PADDLE_SPEED = 100;
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_X = 270;
    private static final int PADDLE_Y = 460;
    private static final String LEVEL_NAME = "Green 3";
    private static final int NUMBER_OF_BALLS_TO_REMOVE = 2;
    private static Sprite background;

    /**
     *
     */
    public Green3() {
        background = new Block(new Rectangle(new Point(0, 0), 600,
                500), Color.green.darker().darker(), -1);


    }

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocity = new ArrayList<>();
        Velocity velocity1 = new Velocity(0, 5);
        ballsVelocity.add(velocity1);
        Velocity velocity2 = new Velocity(0, 5);
        ballsVelocity.add(velocity2);
        return ballsVelocity;
    }

    @Override
    public List<Point> initialBallPoints() {
        List<Point> ballsPoints = new ArrayList<>();
        Point point1 = new Point(280, 330);
        ballsPoints.add(point1);
        Point point2 = new Point(320, 330);
        ballsPoints.add(point2);
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
        int max = 12;
        int blockHeight = 20;
        int blockWidth = 40;
        Color color = null;
        for (int row = 0; row < 5; row++) {
            if (row == 0) {
                color = Color.GRAY;
            }
            if (row == 1) {
                color = Color.RED;
            }
            if (row == 2) {
                color = Color.YELLOW;
            }
            if (row == 3) {
                color = Color.BLUE;
            }
            if (row == 4) {
                color = Color.WHITE;
            }
            for (int col = 0; col < max; col++) {
                Point topLeft = new Point(580 - blockWidth * (col + 1),
                        90 + (row + 1) * blockHeight);
                Block block = null;
                if (row == 0) {
                    block = new Block(new Rectangle(topLeft, blockWidth,
                            blockHeight), color, 1);
                } else {
                    block = new Block(new Rectangle(topLeft, blockWidth,
                            blockHeight), color, 1);
                }
                listBlocks.add(block);
            }
            max--;
        }
        return listBlocks;
    }

    /**
     * @return listLines list of lines
     */
    public List<LineDraw> lines() {
        List<LineDraw> listLines = new ArrayList<>();
        return listLines;
    }

    /**
     * @return listCircle list of circles
     */
    public List<CircleDraw> circles() {
        List<CircleDraw> listCircle = new ArrayList<>();
        CircleDraw smallBigBall = new CircleDraw(100, 190, 8,
                Color.orange.darker(), true);
        listCircle.add(smallBigBall);
        CircleDraw smallBall = new CircleDraw(100, 190, 6,
                Color.red.brighter().brighter().brighter(), true);
        listCircle.add(smallBall);
        CircleDraw smallestBall = new CircleDraw(100, 190, 3,
                Color.white, true);
        listCircle.add(smallestBall);
        return listCircle;
    }


    @Override
    public List<RectangleDraw> rectangles() {
        List<RectangleDraw> rectangleDraw = new ArrayList<>();
        double x = 65, y = 352;
        RectangleDraw bigRec = new RectangleDraw(new Point(59, 348),
                130, 83, Color.gray.darker().darker());
        rectangleDraw.add(bigRec);
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                RectangleDraw window = new RectangleDraw(new Point(x, y),
                        23.6, 10, Color.white);
                rectangleDraw.add(window);
            }
            x += 15.5;
        }
        RectangleDraw smallRec = new RectangleDraw(new Point(86.5, 298),
                50, 28, Color.gray.darker());
        rectangleDraw.add(smallRec);
        RectangleDraw tallRec = new RectangleDraw(new Point(95, 198),
                100, 10, Color.gray.brighter());
        rectangleDraw.add(tallRec);
        return rectangleDraw;
    }

        @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BALLS_TO_REMOVE;
    }
}

