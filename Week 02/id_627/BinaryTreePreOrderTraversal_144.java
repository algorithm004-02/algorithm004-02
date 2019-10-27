package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 王楠
 * @Description:
 * @Date: Created in 17:48 2019/10/23
 */
public class BinaryTreePreOrderTraversal_144 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal01(TreeNode root) {

        return preOrder(root, new ArrayList<Integer>());
    }

    private static List<Integer> preOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
        return list;
    }


    /**
     * 栈
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return list;
    }

    /**
     * 莫斯里
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal03(TreeNode root) {
        return null;
    }

}
