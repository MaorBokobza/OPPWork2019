import biuoop.DrawSurface;

/**
 *
 */
public interface Animation {
    /**
     * @param d draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return true or false.
     */
    boolean shouldStop();
}
