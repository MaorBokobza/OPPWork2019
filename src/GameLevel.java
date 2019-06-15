import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maor Bokobza.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private static boolean over = false;
    private Counter blocksRemaining;
    private Counter ballsRemaining;
    private Counter rectanglesRemaining;
    private static Counter score = new Counter();
    private static Counter lives = new Counter(7);
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * constructor.
     *
     * @param levelInformation an object from LevelInformation, which consists
     *                         the information about every level.
     */
    public GameLevel(LevelInformation levelInformation) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        blocksRemaining = new Counter();
        ballsRemaining = new Counter();
        rectanglesRemaining = new Counter();
        running = false;
        this.levelInformation = levelInformation;
    }

    /**
     *
     * @param levelInformation LevelInformation parameter.
     * @param ks KeyboardSensor parameter
     * @param ar AnimationRunner parameter
     * @param gui GUI parameter
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor ks,
                     AnimationRunner ar, GUI gui) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        blocksRemaining = new Counter();
        ballsRemaining = new Counter();
        rectanglesRemaining = new Counter();
        running = false;
        this.runner = ar;
        this.keyboard = ks;
        this.gui = gui;
        this.levelInformation = levelInformation;

    }
    /**
     *
     * @return score player's score.
     */
    public static Counter getScore() {
        return score;
    }

    /**
     *
     * @return lives number of player's lives.
     */
    public Counter getLivesRemaining() {
        return lives;
    }

    /**
     * @return blocksRemaining number of remaining blocks.
     */
    public Counter getBlocksRemaining() {
        return blocksRemaining;
    }

    /**
     * decrease number of remaining blocks by 1.
     */
    public void decreaseblock() {
        blocksRemaining.decrease(1);
    }

    /**
     * decrease number of lives by 1.
     */
    public void decreaselive() {
        lives.decrease(1);
    }

    /**
     * @return ballsRemaining number of remining balls.
     */
    public Counter getBallsRemaining() {
        return ballsRemaining;
    }

    /**
     * @return rectanglesRemaining number of remaining rectangles.
     */
    public Counter getRectanglesRemaining() {
        return rectanglesRemaining;
    }

    /**
     * @param c collidable.
     */
    public void addCollidable(Collidable c) {
        if (c != null) {
            environment.addCollidable(c);
        }
    }

    /**
     * @param c collidable.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        if (s != null) {
            sprites.addSprite(s);
        }
    }

    /**
     * @param s asdad
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * @return !this.running
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * @return environment environment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }
    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        DrawSurface d = gui.getDrawSurface();
        Sprite background = levelInformation.getBackground();
        background.addToGame(this);

        Block upperBorder = new Block(new Rectangle(
                new Point(0, 0), 600, 20), Color.GRAY, 0);
        upperBorder.addToGame(this);

        ScoreIndicator scoreIndicator = new ScoreIndicator(score, 150);
        scoreIndicator.addToGame(this);

        LivesIndicator livesIndicator = new LivesIndicator(lives, 50);
        livesIndicator.addToGame(this);

        LevelNameIndicator levelNameIndicator =
                new LevelNameIndicator(levelInformation.levelName());
        levelNameIndicator.addToGame(this);

        Block lowerBorder = new Block(new Rectangle(
                new Point(20, 480), 580, 20), Color.GRAY, 0);
        lowerBorder.addToGame(this);
        lowerBorder.addHitListener(new BallRemover(this, ballsRemaining));

        Block leftBorder = new Block(new Rectangle(
                new Point(0, 20), 20, 480),
                Color.GRAY, 0);
        leftBorder.addToGame(this);

        Block rightBorder = new Block(new Rectangle(
                new Point(580, 20), 20, 460),
                Color.GRAY, 0);
        rightBorder.addToGame(this);

        List<Block> blocks = levelInformation.blocks();
        blocksRemaining = new Counter();
        for (Block block : blocks) {
            block.addHitListener(new BlockRemover(this, blocksRemaining));
            block.addHitListener(new ScoreTrackingListener(score));
            block.addToGame(this);
        }
        List<LineDraw> linedraw = levelInformation.lines();
        for (LineDraw lineDraws : linedraw) {
            lineDraws.addToGame(this);
        }
        List<CircleDraw> circlelist = levelInformation.circles();

        for (CircleDraw circles : circlelist) {
            circles.addToGame(this);
        }

        List<RectangleDraw> rectangleDraws = levelInformation.rectangles();
        if (rectangleDraws != null) {
            for (RectangleDraw rect : rectangleDraws) {
                rect.addToGame(this);
            }
        }

    }

    /**
     *
     */
    private void removeAllPaddles() {
        ArrayList<Paddle> toRemove = new ArrayList<>();

        for (Sprite s : sprites.getSpriteList()) {
            if (s instanceof Paddle) {
                Paddle paddle = (Paddle) s;
                toRemove.add(paddle);
            }
        }
        for (Paddle p : toRemove) {
            removeSprite(p);
            removeCollidable(p);
        }
    }

    /**
     * @param d draw surface
     */
    public void doOneFrame(DrawSurface d) {

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        if (blocksRemaining.getValue() == 0) {
            score.increase(100);
            removeAllPaddles();
            this.running = false;
        }
        if (this.ballsRemaining.getValue() == 0) {
            removeAllPaddles();
            this.running = false;
        }
        if (lives.getValue() == 0) {
            this.runner.run(new EndScreen(this.keyboard, score, false, this.gui));
        }

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void playOneTurn() {
        this.createBallsOnTopOfPaddle(levelInformation.numberOfBalls(),
                levelInformation.initialBallVelocities(),
                levelInformation.initialBallPoints());
        this.creatrPaddle(levelInformation.paddleSpeed(),
                levelInformation.paddleWidth());
        this.running = true;
        this.runner.run(new CountdownAnimation(2., 3, sprites));
        this.runner.run(this);
    }

    /**
     * @param numberOfBalls         the number of ball/s.
     * @param initialBallVelocities the initial velocity of the ball/s.
     * @param initialBallPoints     the initial points
     */
    public void createBallsOnTopOfPaddle(int numberOfBalls,
                                         List<Velocity> initialBallVelocities,
                                         List<Point> initialBallPoints) {
        for (int i = 0; i < numberOfBalls; i++) {
            Ball ball1 = new Ball(new Point(initialBallPoints.get(i).getX(),
                    initialBallPoints.get(i).getY()), 5, Color.WHITE,
                    environment);
            ball1.setVelocity(initialBallVelocities.get(i));
            ball1.addToGame(this);
        }
    }

    /**
     * @param paddleSpeed the paddle's speed.
     * @param paddleWidth the paddle's width.
     */
    public void creatrPaddle(int paddleSpeed, int paddleWidth) {
        Paddle paddle = new Paddle(new Rectangle(new Point(levelInformation.paddleX(),
                levelInformation.paddleY()),
                paddleWidth, 8),
                Color.yellow,
                this.keyboard,
                20,
                580);
        paddle.addToGame(this);
    }

    /**
     *
     */
    public void run() {
        lives.increase(4);
        while (lives.getValue() > 0) {
            playOneTurn();
            lives.decrease(1);
        }


        playOneTurn();
    }
}

