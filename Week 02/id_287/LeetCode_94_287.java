package com.tulane.mine;

import com.alibaba.fastjson.JSON;
import com.tulane.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
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
 */

/**
 * 思路: 中序遍历递归 左根右
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);


        System.out.println(JSON.toJSON(new InorderTraversal().inorderTraversal(treeNode)));
    }

    /**
     * TODO 未写出来
     * 第三种 广度优先遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            if(root.right != null) stack.push(root.right);
            if(root.left != null){
                stack.push(root.left);
                root = root.left;
            }else{
                TreeNode node = (TreeNode) stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }


    /**
     * 重写一遍入栈法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //最后放入的出队
            TreeNode node = (TreeNode) stack.pop();
            //最先遍历最左节点, 根节点被看做左节点的上一级, 由栈推出后被输出
            //所以此步可看做是左节点与根节点的输出
            list.add(node.val);
            //将右节点看做根, 它会入栈, 入栈后会继续入栈它的所有的左子节点
            root = node.right;
        }
        return list;
    }

    /**
     * 第二种 栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = (TreeNode) stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list;
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        recursion(root, list);
        return list;
    }

    private void recursion(TreeNode root, List<Integer> list) {
        if (root.left != null) recursion(root.left, list);
        list.add(root.val);
        if (root.right != null) recursion(root.right, list);
    }

}
