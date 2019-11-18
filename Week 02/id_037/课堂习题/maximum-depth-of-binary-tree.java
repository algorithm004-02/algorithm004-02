// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int depth) {
        if (root == null) return depth;
        int curr = depth + 1;
        int leftDepth = helper(root.left, curr);
        int rightDepth = helper(root.right, curr);
        return Math.max(leftDepth, rightDepth);
    }
}

// todo: 迭代法