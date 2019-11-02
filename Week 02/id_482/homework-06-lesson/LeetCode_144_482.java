package com.study.homework.week02_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/23
 * @link
 */
public class LeetCode_144_482 {

    /**
     * 解法一：二叉树的前序 非递归实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root == null)
            return list;


        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur=stack.pop();
            list.add(cur.val);//

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
        return list;
    }

    /**
     * 解法2：二叉树的前序 递归实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> list=new ArrayList<>();

        preOrder(root,list);
        return list;
    }

    //递归实现 二叉树的前序遍历
    private void preOrder(TreeNode node, List<Integer> list) {
        if (null == node)
            return;

        list.add(node.val);

        preOrder(node.left,list);
        preOrder(node.right,list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
