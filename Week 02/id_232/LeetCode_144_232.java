package src.main.java.com.fans.algorithm00402.week2.homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 【二叉树的前序遍历】
给定一个二叉树，返回它的 前序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*
*  */
public class LeetCode_144_232 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /* 1、 递归 O(n)  O(n) */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
//    }
//
//    private void helper(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            res.add(root.val);
//            helper(root.left, res);
//            helper(root.right, res);
//        }
//    }

    /* 2、使用stack遍历 O(n) O(n) */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        if (node != null) stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return res;
    }
}
