/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        traversal(list, root);
        return list;
    }

    void traversal(List<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        if (node.children != null) {
            for (Node child : node.children) {
                traversal(list, child);
            }
        }
        list.add(node.val);
    }
}
// @lc code=end

