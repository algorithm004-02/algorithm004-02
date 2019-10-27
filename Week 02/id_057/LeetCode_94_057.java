package app.homeworkWeekTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (58.92%)
 * Likes:    2080
 * Dislikes: 92
 * Total Accepted:    553.2K
 * Total Submissions: 936.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        inorderTraversal_stack(root, stack, result);
        return result;
    }

    /**
     * 利用stack模拟递归调用
     * 时间复杂度O(n) 
     * 空间复杂度O(n)
     * @param root
     * @param result
     */
    private void inorderTraversal_stack(TreeNode root, Stack<TreeNode> stack, List<Integer> result) {
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            TreeNode node = stack.pop();
            result.add(node.val);
            root = node.right;
        }

    }

    /**
     * 递归中序遍历，左，根，右 
     * 时间复杂度O(n) 
     * 空间复杂度O(n)
     * @param root
     * @param result
     */
    private void inorderTraversal_recursion(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal_recursion(root.left, result);
            result.add(root.val);
            inorderTraversal_recursion(root.right, result);
        }
    }



}
// @lc code=end

