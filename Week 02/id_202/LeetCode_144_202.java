package com.algorithm.qinchao.homework.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/30 11:22
 * @description 给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_144_202 {
    public List<Integer> preorderTraversalByRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            recursive(root.left, result);
            recursive(root.right, result);
        }
    }

    public List<Integer> preorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_144_202 leetCode_144_202 = new LeetCode_144_202();
        TreeNode left = new TreeNode(7, new TreeNode(5, null, null), new TreeNode(8, null, null));
        TreeNode right = new TreeNode(15, new TreeNode(13, null, null), new TreeNode(18, null, null));
        TreeNode tree = new TreeNode(10, left, right);
        System.out.println(leetCode_144_202.preorderTraversalByRecursive(tree));
        System.out.println(leetCode_144_202.preorderTraversalByStack(tree));
    }
}
