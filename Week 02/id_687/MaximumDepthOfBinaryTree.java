package com.itliusir.tree;

import com.itliusir.util.TreeNode;

/**
 * problem.104
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author liugang
 * @date 2019-10-27
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int level = new MaximumDepthOfBinaryTree().maxDepth(root);
        System.out.println(level);
    }

    /**
     * method 1 -> time O(n) space O(n)
     *
     * 暴力递归
     * level =
     * maxH(left,right) + 1 =
     * maxH(maxH(left.left,left.right),maxH(right.left,right.right)) + 1 =
     * ...
     *
     * @author liugang
     * @date 2019-10-27 17:23:05
     */
    public int maxDepth(TreeNode root) {
        return doMaxDepth(root);
    }

    private int doMaxDepth(TreeNode root) {
        int level1 = 0,level2 = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            level1 = doMaxDepth(root.left);
        }
        if (root.right != null) {
            level2 = doMaxDepth(root.right);
        }
        return Math.min(level1, level2) + 1;
    }




}
