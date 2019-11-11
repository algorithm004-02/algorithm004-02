package com.itliusir.tree;

import com.itliusir.util.TreeNode;

import java.util.Stack;

/**
 * problem.98
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * @author liugang
 * @date 2019-10-27
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }

    /**
     * method 1 -> time O(n) space O(n)
     *
     * 递归解法
     *
     * @author liugang
     * @date 2019-10-27 16:47:20
     */
    public boolean isValidBST(TreeNode root) {
        return doIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doIsValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        // terminator
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        // process current logic

        //drill down
        // 1. save temp root.val
        // 2. mark min && max
        return doIsValidBST(root.left, minValue, root.val) && doIsValidBST(root.right, root.val, maxValue);
    }

    /**
     * method 2 -> time O(n) space O(n)
     *
     * 通过迭代法中序遍历保存前一个节点值与后一个比较
     *
     * @author liugang
     * @date 2019-10-27 17:08:02
     */
    public boolean isValidBSTTwo(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while (root != null || !stack.isEmpty()) {
            //traversal left node
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //traversal in node
            root = stack.pop();
            // check pre node < cur node
            if (preNode != null && root.val <= preNode.val) {
                return false;
            }
            // save pre node val
            preNode = root;
            //traversal right node
            root = root.right;
        }
        return true;
    }
}
