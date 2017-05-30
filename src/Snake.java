import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    List<Node> nodeList;

    Direction direction;
    int velocity = 25;

    Rectangle head;

    int nodeAmount;

    public Node getHead() {
        return nodeList.get(0);
    }

    public Snake() {
        nodeList = new LinkedList<>();
        direction = Direction.NORTH;
        head = new Rectangle();
        head.setSize(25, 25);
        nodeList.add(new Node(100, 100));
        nodeList.add(new Node(125, 100));
        nodeList.add(new Node(150, 100));
        nodeList.add(new Node(175, 100));
    }

    public void addNode() {

        for(int i = nodeList.size() - 1; i > 0; i--) {
            nodeList.set(i, nodeList.get(i-1));
        }

        if(direction.equals(Direction.NORTH)) {
            nodeList.add(0, new Node(nodeList.get(0).x, nodeList.get(0).y - velocity));
        } else if(direction.equals(Direction.EAST)) {
            nodeList.add(0, new Node(nodeList.get(0).x + velocity, nodeList.get(0).y));
        } else if(direction.equals(Direction.SOUTH)) {
            nodeList.add(0, new Node(nodeList.get(0).x, nodeList.get(0).y + velocity));
        } else if(direction.equals(Direction.WEST)) {
            nodeList.add(0, new Node(nodeList.get(0).x - velocity, nodeList.get(0).y));
        }
    }

    public void updateNodePositions() {
        head.setLocation(nodeList.get(0).x, nodeList.get(0).y);
        for(int i = nodeList.size() - 1; i > 0; i--) {
            nodeList.set(i, nodeList.get(i-1));
        }

        if(direction.equals(Direction.NORTH)) {
            nodeList.set(0, new Node(nodeList.get(0).x, nodeList.get(0).y - velocity));
        } else if(direction.equals(Direction.EAST)) {
            nodeList.set(0, new Node(nodeList.get(0).x + velocity, nodeList.get(0).y));
        } else if(direction.equals(Direction.SOUTH)) {
            nodeList.set(0, new Node(nodeList.get(0).x, nodeList.get(0).y + velocity));
        } else if(direction.equals(Direction.WEST)) {
            nodeList.set(0, new Node(nodeList.get(0).x - velocity, nodeList.get(0).y));
        }

    }

}
