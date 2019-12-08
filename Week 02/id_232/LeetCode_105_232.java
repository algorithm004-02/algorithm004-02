package src.main.java.com.fans.algorithm00402.week2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 【从前序与中序遍历序列构造二叉树】
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class LeetCode_105_232 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] perorder, int pbegin, int pend, int[] inorder, int inbegin, int inend) {

        if (pbegin > pend || inbegin > inend) return null;
        int nodeVal = perorder[pbegin];
        int index = 0;
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == nodeVal) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(perorder[pbegin]);
        node.left = helper(perorder, pbegin + 1, pbegin + index - inbegin, inorder, inbegin, index - 1);
        node.right = helper(perorder, pbegin + index + 1 - inbegin, pend, inorder, index + 1, inend);
        return node;
    }
}
