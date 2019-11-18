import java.util.List;
public class Node {
    int val;
    List<Node> children;
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}