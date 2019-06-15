import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maor Bokobza
 */
public  final class HighScoresTable {
    private int size;
    private List<ScoreInfo> scoreInfoList;

    // Create an empty high-scores table with the specified size.
    // The size means that the table holds up to size top scores.

    /**
     *
     * @param size table size.
     */
    public HighScoresTable(int size) {
        this.size = size;
        this.scoreInfoList = new ArrayList<>();
    }

    // Add a high-score.

    /**
     *
     * @param score a player's name and score.
     */
    public void add(ScoreInfo score) {
        if (scoreInfoList.isEmpty()) {
            scoreInfoList.add(score);
            return;
        }
        int rank = getRank(score.getScore());
        size = scoreInfoList.size();
        if (rank <= size) {
            scoreInfoList.add(rank - 1, score);
        }
    }

    // Return table size.

    /**
     *
     * @return table size.
     */
    public int size() {
        return size;
    }

    // Return the current high scores.
    // The list is sorted such that the highest
    // scores come first.

    /**
     *
     * @return scoreInfoList the list with the players' names and scores.
     */
    public List<ScoreInfo> getHighScores() {
        return scoreInfoList;
    }

    // return the rank of the current score: where will it
    // be on the list if added?
    // Rank 1 means the score will be highest on the list.
    // Rank `size` means the score will be lowest.
    // Rank > `size` means the score is too low and will not
    //      be added to the list.

    /**
     *
     * @param score the player's score.
     * @return 1 if list is empty, i + 1 if score > specific score in table,
     * or size + 1 if score < all scores in the table.
     */
    public int getRank(int score) {
        if (this.scoreInfoList.isEmpty()) {
            return 1;
        }
        for (int i = 0; i < size; i++) {

                if (score > scoreInfoList.get(i).getScore()) {
                    return i + 1;
                }

        }
        return size + 1;
    }

    // Clears the table

    /**
     *  clearing the table.
     */
    public void clear() {
            scoreInfoList.clear();
    }

    // Load table data from file.
    // Current table data is cleared.

    /**
     *
     * @param filename file's name.
     * @throws IOException IO exception
     */
    public void load(File filename) throws IOException {
        HighScoresTable highScoresTable = loadFromFile(filename);
        if (highScoresTable.size() != 0) {
            this.size = highScoresTable.size; // change the current value to the file values.
            this.scoreInfoList = highScoresTable.scoreInfoList;
        } else {
            throw new IOException("Error in IO");
        }

    }

    // Save table data to the specified file.

    /**
     *
     * @param filename file's name.
     * @throws IOException IO exception.
     */
    public void save(File filename) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    // Read a table from file and return it.
    // If the file does not exist, or there is a problem with
    // reading it, an empty table is returned.

    /**
     *
     * @param filename file's name.
     * @return new HighScoresTable(10) a new table in case the file is empty.
     */

    public static HighScoresTable loadFromFile(File filename) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            return (HighScoresTable) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new HighScoresTable(10);
    }
}