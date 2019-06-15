/**
 * @author Maor Bokobza.
 */
public class Counter {
    private int counter = 0;

    // add number to current count.

    /**
     *
     * @param num a number that is counted.
     */
    public Counter(int num) {
        this.counter = num;
    }
    /**
     * counter.
     */
    public Counter() {
    }

    /**
     * @param number a certain number.
     */
    void increase(int number) {
        counter += number;
    }
    // subtract number from current count.

    /**
     * @param number a certain number.
     */
    void decrease(int number) {
        counter -= number;
    }
    // get current count.

    /**
     * @return counter a counter that counts things.
     */
    int getValue() {
        return counter;
    }
}