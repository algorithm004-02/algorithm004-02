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
    private TreeNode best;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode matchedNodeLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode matchedNodeRight = lowestCommonAncestor(root.right, p, q);
        if (matchedNodeLeft == p && matchedNodeRight == q || matchedNodeLeft == q && matchedNodeRight == p) {
            this.best = root;
            return root;
        } else if (matchedNodeLeft == q || matchedNodeRight == q) {
            return q;
        } else if (matchedNodeLeft == p || matchedNodeRight == p) {
            return p;
        } else {
            //始终返回第一次匹配的。
            return this.best;
        }
    }
    
}