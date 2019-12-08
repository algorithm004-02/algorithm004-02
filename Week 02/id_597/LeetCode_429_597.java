import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 * Created by yangwenwei on 2019/10/25.
 */
public class LeetCode_429_597 {

    class Solution {

        //栈的迭代
        public List<List<Integer>> levelOrder1(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> list = new ArrayList<>();
                while (count-- > 0) {
                    Node node = queue.poll();
                    if (node != null) {
                        list.add(node.val);
                        for (Node n : node.children) {
                            if (n != null) queue.add(n);
                        }
                    }
                }
                if (!list.isEmpty()) result.add(list);
            }
            return result;
        }

        //递归解法
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            recursion(root, 0, result);
            return result;
        }

        private void recursion(Node node, int depth, List<List<Integer>> result) {
            //terminator
            if (node == null) return;
            //判断当前深度是否大于数组的长度, 若是,则说明添加新层了,需在数组加个空数组元素.
            if (depth + 1 > result.size()) result.add(new ArrayList<>());
            result.get(depth).add(node.val);
            for (Node n : node.children) {
                recursion(n, depth + 1, result);
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
