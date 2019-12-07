/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int[] preorder;
    int[] inorder;
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildSubTree(0, inorder.length);
    }

    TreeNode buildSubTree(int left, int right) {
        if (left == right) {
            return null;
        }
        TreeNode result = new TreeNode(preorder[preIndex]);
        int index = map.get(preorder[preIndex++]);
        result.left = buildSubTree(left, index);
        result.right = buildSubTree(index + 1, right);
        return result;
    }
}
// @lc code=end
