package WEEK2.LeetCode.TreeQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * */

/*
* 前序遍历：根 - 左 - 右
* 中序遍历：左 - 根 - 右
* 后序遍历：左 - 右 - 根
* */


public class InorderTraversal {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    /**
     方法1：递归
     思路：基本写法，left - root - right
     */

    /* 递归基本写法*/
    public List< Integer > inorderTraversal_default(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recur(root,result);
        return result;
    }

    /**
     方法2：维护栈，存储当前node
     思路：left - root - right
          node val压入栈，然后按照顺序对比，如果不符则pop
     */
    public List< Integer > inorderTraversal_Stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        //stack不为null 且当前节点不为null
        while (current != null || !stack.isEmpty()) {
            //压入栈node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            //左边遍历完，开始右边
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    /**
     *莫里斯。 结果生成一条线性链表
     Step 1: 将当前节点current初始化为根节点
     Step 2: While current不为空，
     若current没有左子节点
     a. 将current添加到输出
     b. 进入右子树，亦即, current = current.right
     否则
     a. 在current的左子树中，令current成为最右侧节点的右子节点
     b. 进入左子树，亦即，current = current.left
     */
    public List<Integer> inorderTraversal_More(TreeNode root ) {
        List<Integer> result = new ArrayList<>();
        //Step 1
        TreeNode cur = root;
        TreeNode pre ;
        //Step 2
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right; // move to right
            } else {
                //have left tree
                pre = cur.left;
                while (pre.right != null) { //find right limit
                    pre = pre.right;
                }

                pre.right = cur;//put cur after pre node;
                TreeNode temp = cur;
                cur = cur.left; //move cur to top of new tree
                temp.left = null;//original cur left be null,avoid dead loop
            }
        }
        return result;
    }

    private void recur(TreeNode root, List<Integer> result) {
        if (root != null) {
            //left
            if (root.left != null) {
                recur(root.left,result);
            }
            //middle,root处理
            result.add(root.val);
            //right
            if (root.right != null) {
                recur(root.right,result);
            }
        }
    }



}
