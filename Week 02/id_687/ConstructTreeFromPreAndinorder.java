package com.itliusir.tree;

import com.itliusir.util.TreeNode;

/**
 * problem.105
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author liugang
 * @date 2019-10-27
 */
public class ConstructTreeFromPreAndinorder {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        // debugger look
        TreeNode treeNode = new ConstructTreeFromPreAndinorder().buildTree(preorder, inorder);
    }

    /**
     * method 1 -> time O(n) space O(n)
     *
     * 递归分治
     * 1. 根据前序遍历获得root node
     * 2. 根据root node 把中序遍历拆分2份，并计算左右树长度
     * 3. 根据长度确定前序遍历的左右子树，再对左右子树重复以上操作
     *
     * @author liugang
     * @date 2019-10-27 21:06:04
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(0, 0, preorder.length - 1, preorder, inorder);
    }


    private TreeNode doBuildTree(int preL, int inL, int inEnd, int[] preorder, int[] inorder) {
        // terminator
        if (preL > preorder.length - 1 || inL > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int pivot = 0;
        for (int i = inL; i <= inEnd; i++) {
            // find curr root index
            if (inorder[i] == root.val) {
                pivot = i;
            }
        }
        // left index = preL + 1
        root.left = doBuildTree(
                preL + 1,
                inL,
                pivot - 1,
                preorder,
                inorder);
        // right index = left length + preL + 1
        root.right = doBuildTree(
                preL + pivot - inL + 1,
                pivot + 1,
                inEnd,
                preorder,
                inorder);
        return root;
    }
}
