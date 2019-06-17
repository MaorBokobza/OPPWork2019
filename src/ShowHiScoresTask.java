public class ShowHiScoresTask implements Task<Void> {
    private final HighScoresAnimation highScoreAnimation;
    private AnimationRunner runner;

    public ShowHiScoresTask(AnimationRunner runner, HighScoresAnimation highScoresAnimation) {
        this.runner = runner;
        this.highScoreAnimation = highScoresAnimation;
    }

    public Void run() {
        this.runner.run(this.highScoreAnimation);
        return null;
    }
}