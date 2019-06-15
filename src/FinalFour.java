import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Maor Bokobza.
 */
public class FinalFour implements LevelInformation {
    private static final int NUMBER_OF_BALLS = 3;
    private static final int PADDLE_SPEED = 100;
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_X = 270;
    private static final int PADDLE_Y = 460;
    private static final String LEVEL_NAME = "Final Four";
    private static final int NUMBER_OF_BALLS_TO_REMOVE = 3;
    private static Sprite background;

    /**
     *
     */
    public FinalFour() {
        background = new Block(new Rectangle(new Point(0, 0), 600,
                500), Color.cyan.darker().darker(), -1);


    }

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocity = new ArrayList<>();
        Velocity velocity1 = new Velocity(0.01, 5);
        ballsVelocity.add(velocity1);
        Velocity velocity2 = new Velocity(0.01, 5);
        ballsVelocity.add(velocity2);
        Velocity velocity3 = new Velocity(0.01, 5);
        ballsVelocity.add(velocity3);
        return ballsVelocity;
    }

    @Override
    public List<Point> initialBallPoints() {
        List<Point> ballsPoints = new ArrayList<>();
        Point point1 = new Point(270, 330);
        ballsPoints.add(point1);
        Point point2 = new Point(294, 315);
        ballsPoints.add(point2);
        Point point3 = new Point(318, 330);
        ballsPoints.add(point3);
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
        int max = 16;
        int blockHeight = 20;
        int blockWidth = 35;
        Color color = null;
        for (int row = 0; row < 7; row++) {
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
                color = Color.GREEN;
            }
            if (row == 4) {
                color = Color.WHITE;
            }
            if (row == 5) {
                color = Color.PINK;
            }
            if (row == 6) {
                color = Color.CYAN;
            }
            for (int col = 0; col < max; col++) {
                Point topLeft = new Point(580 - blockWidth * (col + 1),
                        50 + (row + 1) * blockHeight);
                Block block = new Block(new Rectangle(topLeft, blockWidth,
                            blockHeight), color, 1);
                listBlocks.add(block);
            }
        }
        return listBlocks;
    }

    /**
     * @return listLines list of lines
     */
    public List<LineDraw> lines() {
        List<LineDraw> listLines = new ArrayList<>();
        int x = 60, y = 480;
        int x2 = 80, y2 = 350;
        int x3 = 410, y3 = 480;
        int x4 = 430, y4 = 430;
        for (int i = 0; i < 10; i++) {
            x += 9;
            x2 += 9;
            LineDraw rain1 = new LineDraw(x, y, x2, y2, Color.white);
            listLines.add(rain1);
        }
        for (int j = 0; j < 10; j++) {
            x3 += 8;
            x4 += 8;
            LineDraw rain2 = new LineDraw(x3, y3, x4, y4, Color.white);
            listLines.add(rain2);
        }
        return listLines;
    }

    /**
     * @return listCircle list of circles
     */
    public List<CircleDraw> circles() {
        List<CircleDraw> listCircle = new ArrayList<>();
        CircleDraw b1 = new CircleDraw(82, 346, 24, Color.white,
                true);
        listCircle.add(b1);
        CircleDraw b2 = new CircleDraw(110, 352, 27, Color.white,
                true);
        listCircle.add(b2);
        CircleDraw b3 = new CircleDraw(114, 330, 27,
                Color.gray.brighter(), true);
        listCircle.add(b3);
        CircleDraw b4 = new CircleDraw(130, 370, 22,
                Color.gray.darker(), true);
        listCircle.add(b4);
        CircleDraw b5 = new CircleDraw(157, 342, 33,
                Color.gray.darker(), true);
        listCircle.add(b5);
        CircleDraw b6 = new CircleDraw(432, 426, 23, Color.white,
                true);
        listCircle.add(b6);
        CircleDraw b7 = new CircleDraw(460, 432, 26, Color.white,
                true);
        listCircle.add(b7);
        CircleDraw b8 = new CircleDraw(464, 410, 26,
                Color.gray.brighter(), true);
        listCircle.add(b8);
        CircleDraw b9 = new CircleDraw(480, 450, 21,
                Color.gray.darker(), true);
        listCircle.add(b9);
        CircleDraw b10 = new CircleDraw(505, 422, 32,
                Color.gray.darker(), true);
        listCircle.add(b10);
        return listCircle;
    }
    @Override
    public List<RectangleDraw> rectangles() {
        List<RectangleDraw> rectangleDraw = new ArrayList<>();
        return rectangleDraw;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BALLS_TO_REMOVE;
    }
}

