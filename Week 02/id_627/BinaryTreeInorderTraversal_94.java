package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 王楠
 * @Description: 中序遍历二叉树
 * @Date: Created in 14:00 2019/10/23
 */
public class BinaryTreeInorderTraversal_94 {

    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal01(TreeNode root) {
        return inorder(root, new ArrayList<Integer>());
    }

    private static List<Integer> inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }

    /**
     * 栈
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal02(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr!= null){
                stack.push(curr);
                curr =curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;

        }
         return list;
    }

    /**
     * 莫里斯
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal03(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while(curr !=null){
            if(curr.left ==null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                pre = curr.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp =curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return null;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
