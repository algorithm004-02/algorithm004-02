package com.itliusir.tree;

import com.itliusir.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * problem.94
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author liugang
 * @since 2019/10/25
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = new InorderTraversal().inorderTraversal(root);
        list.forEach(integer -> System.out.println(integer));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doInorderTraversalTwo(root, result);
        return result;
    }

    /**
     * method 1 -> time O(n) space O(n)
     * <p>
     * 递归解法
     *
     * @author liugang 2019/10/25 15:02
     */
    private void doInorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            doInorderTraversal(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            doInorderTraversal(root.right, result);
        }
    }

    /**
     * method 2 -> time O(n) space O(n)
     * <p>
     * 使用栈先遍历左节点，暂存中间节点，最后遍历右节点
     *
     * @author liugang 2019/10/25 16:56
     */
    private void doInorderTraversalTwo(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // left node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // in node
            curr = stack.pop();
            result.add(curr.val);
            // right node
            curr = curr.right;
        }
    }


}
