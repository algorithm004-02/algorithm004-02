import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 * Created by yangwenwei on 2019/10/23.
 */
public class LeetCode_590_597 {

    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> rlt = new ArrayList<>();
            recursion(root, rlt);
            return rlt;
        }

        private void recursion(Node node, List<Integer> rlt) {
            if (node != null) {
                for (Node child : node.children) {
                    recursion(child, rlt);
                }
                rlt.add(node.val);
            }
        }
    }

    class Node {
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
