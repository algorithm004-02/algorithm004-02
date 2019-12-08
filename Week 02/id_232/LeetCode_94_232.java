package src.main.java.com.fans.algorithm00402.week2.homework;

/*
* 【二叉树的中序遍历】
*   给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
* */

import java.util.*;

public class LeetCode_94_232 {

    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    private List<Integer> res = new ArrayList(){};

    /* 1. 递归解法 O(n)  O(n) */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root != null) {
//            inorderTraversal(root.left);
//            res.add(root.val);
//            inorderTraversal(root.right);
//        }
//        return res;
//    }

    /* 2. 迭代解法 ： 使用栈  O(n) O(n) */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}
