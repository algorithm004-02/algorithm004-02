// https://leetcode-cn.com/problems/validate-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // 递归
 // 错误解法，只考虑了当前树，而没有考虑整个左右子树
 // todo: 错误
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            if (root.left.val >= root.val ) return false;
            isValidBST(root.left);
        }
        if (root.right != null) {
            if (root.right.val <= root.val) return false;
            isValidBST(root.right);
        }
    }
}
