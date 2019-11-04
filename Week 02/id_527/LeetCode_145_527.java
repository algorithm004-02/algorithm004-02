/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traversal(list, root);
        return list;
    }

    void traversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(list, node.left);
        traversal(list, node.right);
        list.add(node.val);
    }
}
// @lc code=end
