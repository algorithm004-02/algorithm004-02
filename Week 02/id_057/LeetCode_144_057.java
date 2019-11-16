package app.homeworkWeekTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (52.87%)
 * Likes:    983
 * Dislikes: 46
 * Total Accepted:    390.2K
 * Total Submissions: 736.8K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        preorderTraversal_stack_fast(root, stack, result);
        return result;
    }

    /**
     * 递归前序遍历：根，左，右 
     * 时间复杂度O(n) 
     * 空间复杂度O(n)
     * @param root
     * @param stack
     * @param result
     */
    private void preorderTraversal_stack(TreeNode root, Stack<TreeNode> stack, List<Integer> result) {
        while (root != null) {
            result.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
            if (!stack.isEmpty()) root = stack.pop();
            else root = null;
        }
    }

    /**
     * 优化版，减少入栈操作
     * @param root
     * @param stack
     * @param result
     */
    private void preorderTraversal_stack_fast(TreeNode root, Stack<TreeNode> stack, List<Integer> result) {
        while (root != null) {
            result.add(root.val);
            if (root.right != null) stack.push(root.right);
            root = root.left;
            if (root == null && !stack.isEmpty()) root = stack.pop();

        }
    }

     /**
     * 递归前序遍历：根，左，右 
     * 时间复杂度O(n) 
     * 空间复杂度O(n)
     * @param root
     * @param result
     */
    private void preorderTraversal_recursion(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderTraversal_recursion(root.left, result);
            preorderTraversal_recursion(root.right, result);
        }
    }
}
// @lc code=end

