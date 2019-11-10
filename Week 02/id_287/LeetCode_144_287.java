package com.tulane.mine;

import com.alibaba.fastjson.JSON;
import com.tulane.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
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
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);


        System.out.println(JSON.toJSON(new PreorderTraversal().preorderTraversal(treeNode)));
    }

    /**
     * 第三种 广度优先
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            root = (TreeNode) stack.pop();
            list.add(root.val);
            //先将右子节点压入栈底, 这样栈底的最下边会是右子节点的最右子节点
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return list;
    }


    /**
     * 第二种 栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();

        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            TreeNode node = (TreeNode) stack.pop();
            root = node.right;
        }
        return list;
    }

    /**
     * 第一种递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        recursion(root, list);
        return list;
    }

    /**
     * 中序递归 先根节点再左节点再右节点
     *
     * @param root
     * @param list
     */
    private void recursion(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) recursion(root.left, list);
        if (root.right != null) recursion(root.right, list);
    }
}
