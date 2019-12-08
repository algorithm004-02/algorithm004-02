package com.itliusir.tree;

import com.itliusir.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * problem.144
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 *
 * @author liugang
 * @date 2019-10-26
 */

public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = new PreorderTraversal().preorderTraversalFour(root);
        list.forEach(integer -> System.out.println(integer));
    }

    /**
     * method 1 -> time O(n) space O(n)
     * <p>
     * 递归
     *
     * @author liugang
     * @date 2019-10-26 11:29:53
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doPreorderTraversal(result, root);
        return result;
    }

    private void doPreorderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            doPreorderTraversal(result, root.left);
        }
        if (root.right != null) {
            doPreorderTraversal(result, root.right);
        }
    }

    /**
     * method 2 -> time O(n) space O(n)
     * <p>
     * 迭代
     *
     * @author liugang
     * @date 2019-10-26 15:04:58
     */
    public List<Integer> preorderTraversalTwo(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // in node
        stack.push(root);
        while (!stack.isEmpty()) {
            // last push node(left node)
            TreeNode node = stack.pop();
            result.add(node.val);
            // first push node
            if (node.right != null) {
                stack.push(node.right);
            }
            // last push node
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * method 3 time O(n) space O(n)
     * <p>
     * 迭代(另一个版本，栈保存右节点)
     *
     * @author liugang
     * @date 2019-10-26 15:45:44
     */
    public List<Integer> preorderTraversalThree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (root != null) {
            // in order
            //if left no-null traversal left
            //if left null traversal right
            result.add(root.val);
            if (root.right != null) {
                // save temp right node
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return result;
    }

    /**
     * method 4 -> time O(n) space O(n)
     * <p>
     * 通过栈的先入后出顺序实现递归方式
     *
     * @author liugang
     * @date 2019-10-26 16:11:35
     */
    public List<Integer> preorderTraversalFour(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }

}
