// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int depth) {
        if (root == null) return depth;
        int curr = depth + 1;
        
        if (root.left == null) {
            return helper(root.right, curr);
        }
        if (root.right == null) {
            return helper(root.left, curr);
        }
        int leftDepth = helper(root.left, curr);
        int righttDepth = helper(root.right, curr);
        return Math.min(leftDepth, righttDepth);
    }
}

// todo: 迭代