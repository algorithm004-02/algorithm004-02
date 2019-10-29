import javax.swing.tree.TreeNode;

import study_datastructure.week_01_homework_04.analyze_and_implement_queue.Queue;

// https://leetcode-cn.com/problems/invert-binary-tree/description/
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
    public TreeNode invertTree(TreeNode root) {
        // termination condition
        if (root == null) return root;
        // current logic
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // drill down
        invertTree(root.left);
        invertTree(root.right);
        return root;
        // revert
    }
}

// 利用queue迭代
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return root;
    }
}