package app.homeworkWeekSixth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (50.50%)
 * Likes:    1970
 * Dislikes: 55
 * Total Accepted:    467.5K
 * Total Submissions: 916.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrder_queue(root);
    }

    /**
     * 利用队列实现层次遍历
     * Time O(n)
     * Space O(n)
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrder_queue(TreeNode root) {
        if (root == null) return new ArrayList<>(0);

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> subResult = new ArrayList<>(currentSize);
            result.add(subResult);

            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                subResult.add(node.val);
                if (node.left != null)  queue.add(node.left);
                if (node.right != null)  queue.add(node.right);
            }
        }

        return result;
    }



}
// @lc code=end

