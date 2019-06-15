import biuoop.GUI;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Maor Bokobza
 */
public class AbstractArtDrawing {
    /**
     * this method draws lines randomly.
     */
    public void drawRandomLines() {

        GUI gui = new GUI("Random Lines Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        Line[] lines = new Line[10];

        for (int i = 0; i < 10; i++) {
            d.setColor(Color.BLACK);
            lines[i] = Line.generateRandomLine();
            drawLine(lines[i], d);
            Point point = lines[i].middle();
            d.setColor(Color.BLUE);
            d.fillCircle((int) Math.round(point.getX()),
                    (int) Math.round(point.getY()), 3);

            for (int j = 0; j < i; j++) {
                Point intersectionPoint = lines[i].intersectionWith(lines[j]);
                if (intersectionPoint == null) {
                    continue;
                }
                d.setColor(Color.RED);
                d.fillCircle((int) Math.round(intersectionPoint.getX()),
                        (int) Math.round(intersectionPoint.getY()), 3);
            }
        }
        gui.show(d);
    }

    /**
     * @param l line we want to draw
     * @param d DrawSurface surface of the line
     */
    void drawLine(Line l, DrawSurface d) {
        d.drawLine((int) Math.round(l.start().getX()),
                (int) Math.round(l.start().getY()),
                (int) Math.round(l.end().getX()),
                (int) Math.round(l.end().getY()));
    }

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        AbstractArtDrawing drawLines = new AbstractArtDrawing();
        drawLines.drawRandomLines();
    }
}