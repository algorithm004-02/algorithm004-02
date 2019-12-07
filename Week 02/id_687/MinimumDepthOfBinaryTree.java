package com.itliusir.tree;

import com.itliusir.util.TreeNode;

/**
 * problem.111
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  
 *
 * @author liugang
 * @date 2019-10-27
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int level = new MinimumDepthOfBinaryTree().minDepth(root);
        System.out.println(level);
    }

    /**
     * method 1 -> time O(n) space O(n)
     * <p>
     * 暴力递归
     *
     * @author liugang
     * @date 2019-10-27 17:38:20
     */
    public int minDepth(TreeNode root) {
        return doMinDepth(root);
    }

    private int doMinDepth(TreeNode root) {
        int minLevel = Integer.MAX_VALUE;
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        if (root.left != null) {
            minLevel = Math.min(doMinDepth(root.left), minLevel);
        }
        if (root.right != null) {
            minLevel = Math.min(doMinDepth(root.right), minLevel);
        }
        return minLevel + 1;
    }
}
