/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traversal(list, root);
        return list;
    }

    void traversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(list, node.left);
        list.add(node.val);
        traversal(list, node.right);
    }
}
// @lc code=end
