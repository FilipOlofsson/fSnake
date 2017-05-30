public class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Node node) {
        if(this.x == node.x && this.y == node.y)
            return true;
        return false;
    }
}
