/**
 *
 */
public class Testing {

    /**
     *
     */
    public void getRank() {

        int size = 10;
        HighScoresTable highScoresTable = new HighScoresTable(size);
        ScoreInfo scoreInfo = new ScoreInfo("test1", 3);
        highScoresTable.add(scoreInfo);
        scoreInfo = new ScoreInfo("test2", 1);
        highScoresTable.add(scoreInfo);
        scoreInfo = new ScoreInfo("test3", 6);
        highScoresTable.add(scoreInfo);
        int score = 6;
        int res;
       res = highScoresTable.getRank(score);
        System.out.println(res);
    }
}