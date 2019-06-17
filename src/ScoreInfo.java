import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Maor Bokobza
 */
public class ScoreInfo implements Serializable {

    public static Comparator<ScoreInfo> getScoreInfoComparator;
    private String name;
    private int score;

    /**
     *
     * @param name name
     * @param score score
     */
    public ScoreInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     *
     * @return name name
     */
    public String getName() {
        return name;
    }

    /**
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return score score
     */
    public int getScore() {
        return score;
    }
    /**
     *
     */
    public void setScore() {
        this.score = score;
    }

    public static Comparator<ScoreInfo> scoreInfoComparator = new Comparator<ScoreInfo>() {
        public int compare(ScoreInfo scoreInfoComparator, ScoreInfo scoreInfoComparator2) {
            int score1 = scoreInfoComparator.getScore();
            int score2 = scoreInfoComparator2.getScore();

            //ascending order
            return compareInt(score2, score1);

        }
    };


    /**
     *
     * @param x param
     * @param y param
     * @return Integer.compare(x, y)
     */
    public static int compareInt(int x, int y) {
        return Integer.compare(x, y);
    }
}