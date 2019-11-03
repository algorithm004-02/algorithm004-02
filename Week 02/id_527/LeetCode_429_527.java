/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
// @lc code=end

