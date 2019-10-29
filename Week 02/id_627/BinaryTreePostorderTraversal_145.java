package com.example.demo.leetcode;

import sun.reflect.generics.tree.Tree;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 王楠
 * @Description: 二叉树 后序遍历
 * @Date: Created in 9:56 2019/10/24
 */
public class BinaryTreePostorderTraversal_145 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal01(TreeNode root) {
        return postOrder(root, new ArrayList<Integer>());
    }

    private List<Integer> postOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);

        return list;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal02(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            result.addFirst(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }


}
