import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GUI extends Canvas {

    int width, height;
    int points = 0;

    JFrame frame;
    JPanel panel;
    Random rnd;
    boolean running = true;
    Snake snake;
    Image dbImage;
    Graphics dbg;
    Apple apple;

    public GUI(int width, int height) throws InterruptedException {
        this.height = height;
        this.width = width;
        initFrame();
        Engine();
    }

    private void initFrame() {
        frame = new JFrame();
        snake = new Snake();
        rnd = new Random();
        apple = new Apple(width, height);
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Node node : snake.nodeList) {
                    g.fillRect(node.x, node.y, snake.velocity, snake.velocity);
                }
                g.drawRect(apple.x, apple.y, apple.diamater, apple.diamater);
                g.setFont(new Font("Arial", Font.PLAIN, 22));
                g.drawString("" + points, 50, 50);
                if(!running) {
                    g.drawString("You lost. " + points, width/2, height/2);
                }
            }
        };
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        frame.setFocusable(true);


        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W && snake.direction != Direction.SOUTH && snake.direction != Direction.NORTH) {
                    snake.direction = Direction.NORTH;
                    snake.updateNodePositions();
                    panel.repaint();
                } else if(e.getKeyCode() == KeyEvent.VK_D && snake.direction != Direction.WEST && snake.direction != Direction.EAST) {
                    snake.direction = Direction.EAST;
                    snake.updateNodePositions();
                    panel.repaint();
                } else if(e.getKeyCode() == KeyEvent.VK_S && snake.direction != Direction.NORTH && snake.direction != Direction.SOUTH) {
                    snake.direction = Direction.SOUTH;
                    snake.updateNodePositions();
                    panel.repaint();
                } else if(e.getKeyCode() == KeyEvent.VK_A && snake.direction != Direction.EAST && snake.direction != Direction.WEST) {
                    snake.direction = Direction.WEST;
                    snake.updateNodePositions();
                    panel.repaint();
                }
            }
        });
    }

    private void Engine() throws InterruptedException {

        long lastTime = System.nanoTime();
        double delta = 0;

        while(running) {
            long now = System.nanoTime();
            if(now - lastTime > 600000000) {
                if(snake.head.equals(apple.rectangle)) {
                    apple = new Apple(width, height);
                    snake.addNode();
                    points++;
                }
                snake.updateNodePositions();
                panel.repaint();
                lastTime = now;
            }
        }
    }

}
