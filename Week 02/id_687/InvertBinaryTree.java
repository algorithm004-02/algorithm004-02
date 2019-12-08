package com.itliusir.tree;

import com.itliusir.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * problem.226
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * @author liugang
 * @date 2019-10-27
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        // debugger look
        TreeNode treeNode = new InvertBinaryTree().invertTreeTwo(root);
    }

    /**
     * method 1 -> time O(n) space O(n)
     * 暴力递归
     *
     * @author liugang
     * @date 2019-10-27 15:46:55
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        doInvertTree(node, root);
        return node;
    }

    private void doInvertTree(TreeNode node, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            node.right = new TreeNode(root.left.val);
            doInvertTree(node.right, root.left);
        }
        if (root.right != null) {
            node.left = new TreeNode(root.right.val);
            doInvertTree(node.left, root.right);
        }
    }

    /**
     * method 2 -> time O(n) space O(n)
     *
     * 迭代法，使用队列保存节点流，每次取出来两子节点互换
     *
     * @author liugang
     * @date 2019-10-27 16:02:30
     */
    public TreeNode invertTreeTwo(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
