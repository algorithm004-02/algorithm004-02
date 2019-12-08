import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 * Created by yangwenwei on 2019/10/23.
 */
public class LeetCode_589_597 {
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> rlt = new ArrayList<>();
            recusion(root, rlt);
            return rlt;
        }

        private void recusion(Node node, List<Integer> rlt) {
            if (node != null) {
                rlt.add(node.val);
                for (Node child : node.children) {
                    recusion(child, rlt);
                }
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
