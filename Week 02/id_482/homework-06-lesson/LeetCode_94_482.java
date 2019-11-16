package com.study.homework.week02_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/22
 * @link https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LeetCode_94_482 {

    /**
     * 解法一： 正规迭代法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        //解法一 递归实现
//        inOrder(root);
        //解法二 非递归实现（非递归实现需要再深入理解）

        List<Integer> list_1=new ArrayList<>();
        inOrder(root,list_1);
        return list_1;
    }

    public List<Integer> inorderTraversal_2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list_2=new ArrayList<>();
        TreeNode curr=root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr=curr.left;
            }
            curr = stack.pop();
            list_2.add(curr.val);
            curr=curr.right;
        }
        return list_2;
    }

    //中序遍历以node为根节点的二叉树，并将其添加进list
    private void inOrder(TreeNode node,List<Integer> list) {
        //终止条件
        if (node == null)
            return;

        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



}
