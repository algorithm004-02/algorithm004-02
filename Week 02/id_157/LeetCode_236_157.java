package com.kaiyun.leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: Kaiyun
 * @create: 2019-10-27 16:46
 **/
public class LeetCode_236_157 {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ) return false;

        int l = helper(root.left, p, q) ? 1 : 0;
        int r = helper(root.right, p, q) ? 1 : 0;
        int m = (root == p || root == q) ? 1 : 0;
        if (l + m + r >= 2) result = root;
        return l + r + m > 0;
    }
}
