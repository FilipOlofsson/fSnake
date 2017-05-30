import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Apple {

    int x, y;
    int diamater = 25;

    Rectangle rectangle;

    public Apple(int width, int height) {
        Random rnd = new Random();
        this.x = diamater *  rnd.nextInt(width/diamater);
        this.y = diamater *  rnd.nextInt(height/diamater);
        rectangle = new Rectangle();
        rectangle.setSize(diamater, diamater);
        rectangle.setLocation(this.x, this.y);
        rnd = null;                         // Marks the object to be deleted by the Garbage Collector.
    }
}
