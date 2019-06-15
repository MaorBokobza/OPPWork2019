import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Maor Bokobza.
 */
public class WideEasy implements LevelInformation {
    private static final int NUMBER_OF_BALLS = 10;
    private static final int PADDLE_SPEED = 100;
    private static final int PADDLE_WIDTH = 350;
    private static final int PADDLE_X = 130;
    private static final int PADDLE_Y = 460;
    private static final String LEVEL_NAME = "Wide Easy";
    private static final int NUMBER_OF_BALLS_TO_REMOVE = 10;
    private static Sprite background;

    /**
     *
     */
    public WideEasy() {
        background = new Block(new Rectangle(new Point(0, 0), 600,
                500), Color.white, -1);
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
        ballsVelocity.add(velocity);
        ballsVelocity.add(velocity);
        ballsVelocity.add(velocity);
        ballsVelocity.add(velocity);
        ballsVelocity.add(velocity);
        ballsVelocity.add(velocity);
        ballsVelocity.add(velocity);
        ballsVelocity.add(velocity);
        ballsVelocity.add(velocity);
        return ballsVelocity;
    }

    @Override
    public List<Point> initialBallPoints() {
        List<Point> ballsPoints = new ArrayList<>();
        Point point1 = new Point(360, 300);
        ballsPoints.add(point1);
        Point point2 = new Point(380, 320);
        ballsPoints.add(point2);
        Point point3 = new Point(400, 340);
        ballsPoints.add(point3);
        Point point4 = new Point(420, 360);
        ballsPoints.add(point4);
        Point point5 = new Point(440, 380);
        ballsPoints.add(point5);
        Point point6 = new Point(180, 380);
        ballsPoints.add(point6);
        Point point7 = new Point(200, 360);
        ballsPoints.add(point7);
        Point point8 = new Point(220, 340);
        ballsPoints.add(point8);
        Point point9 = new Point(240, 320);
        ballsPoints.add(point9);
        Point point10 = new Point(260, 300);
        ballsPoints.add(point10);
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
        double width = 45.66;
        Block b1 = new Block(new Rectangle(new Point(21, 150), width,
                20), Color.red, 1);
        listBlocks.add(b1);
        Block b2 = new Block(new Rectangle(new Point(67.66, 150), width,
                20), Color.red, 1);
        listBlocks.add(b2);
        Block b3 = new Block(new Rectangle(new Point(114.32, 150), width,
                20), Color.orange, 1);
        listBlocks.add(b3);
        Block b4 = new Block(new Rectangle(new Point(160.98, 150), width,
                20), Color.orange, 1);
        Block b5 = new Block(new Rectangle(new Point(207.64, 150), width,
                20), Color.yellow, 1);
        listBlocks.add(b5);
        Block b6 = new Block(new Rectangle(new Point(254.3, 150), width,
                20), Color.yellow, 1);
        listBlocks.add(b6);
        Block b7 = new Block(new Rectangle(new Point(300.96, 150), width,
                20), Color.green, 1);
        listBlocks.add(b7);
        Block b8 = new Block(new Rectangle(new Point(347.62, 150), width,
                20), Color.green, 1);
        listBlocks.add(b8);
        Block b9 = new Block(new Rectangle(new Point(394.28, 150), width,
                20), Color.blue, 1);
        listBlocks.add(b9);
        Block b10 = new Block(new Rectangle(new Point(440.94, 150), width,
                20), Color.blue, 1);
        listBlocks.add(b10);
        Block b11 = new Block(new Rectangle(new Point(487.6, 150), width,
                20), Color.pink, 1);
        listBlocks.add(b11);
        Block b12 = new Block(new Rectangle(new Point(534.26, 150), width,
                20), Color.pink, 1);
        listBlocks.add(b12);
        listBlocks.add(b4);
        return listBlocks;
    }

    /**
     * @return listLines list of lines.
     */
    public List<LineDraw> lines() {
        List<LineDraw> listLines = new ArrayList<>();
        int x = 80, y = 80;
        int x2 = 18, y2 = 149;
        float[] hsb = new float[3];
        Color.RGBtoHSB(238, 232, 172, hsb);
        for (int i = 0; i < 76; i++) {
            if (i < 24) {
                x += 3;
                x2 += 3;
                y += 2;
            }
            if (i > 24 && i < 48) {
                x -= 3;
                x2 += 3;
                y -= 1;
            }
            if (i > 48 && i < 75) {
                x += 1;
                x2 += 16;
                y -= 2;
            }
            LineDraw l4 = new LineDraw(x, y, x2, y2, Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
            listLines.add(l4);
        }
        return listLines;
    }

    /**
     * @return listCircle list of circles.
     */
    public List<CircleDraw> circles() {
        List<CircleDraw> listCircle = new ArrayList<>();
        float[] hsb = new float[3];
        Color.RGBtoHSB(254, 225, 23, hsb);
        CircleDraw b1 = new CircleDraw(120, 80, 37, Color.getHSBColor(hsb[0], hsb[1], hsb[2]), true);
        Color.RGBtoHSB(234, 215, 74, hsb);
        CircleDraw b2 = new CircleDraw(120, 80, 45, Color.getHSBColor(hsb[0], hsb[1], hsb[2]), true);
        Color.RGBtoHSB(238, 232, 172, hsb);
        CircleDraw b3 = new CircleDraw(120, 80, 55, Color.getHSBColor(hsb[0], hsb[1], hsb[2]), true);
        listCircle.add(b3);
        listCircle.add(b2);
        listCircle.add(b1);
        return listCircle;
    }


    @Override
    public List<RectangleDraw> rectangles() {
        List<RectangleDraw> listRectangle = new ArrayList<>();

        return null;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BALLS_TO_REMOVE;
    }
}
