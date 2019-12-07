import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_137 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        //terminator
        if (root == null) return res;
        //process
        res.add(root.val);
        //drill down
        for (Node children : root.children) {
            preorder(children);
        }
        //reverse stat
        return res;
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
