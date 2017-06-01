import java.util.Random;

public class Apple {

    int x, y;
    int diameter = 25;

    public Apple(int width, int height) {
        Random rnd = new Random();
        this.x = 1 + rnd.nextInt(width/diameter);
        this.y = rnd.nextInt(height/diameter);
        this.x *= diameter;
        this.y *= diameter;
        if(this.x > width - (diameter*3) || this.y > height - (diameter*3)) {
            this.x -= 3 * diameter;
            this.y -= 2 * diameter;
        }
        if(this.x < (2 * diameter) || this.y < (2 * diameter)) {
            this.x += 2 * diameter;
            this.y += 3 * diameter;
        }
        System.out.println(this.x + ", "+this.y);
        rnd = null;                         // Marks the object to be deleted by the Garbage Collector.
    }
}
