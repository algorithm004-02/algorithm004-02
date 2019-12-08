/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
    236. 二叉树的最近公共祖先
    递归 
*/
class Solution {
    private TreeNode ans;
    
    public Solution() {
        this.ans = null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }
    
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        
        if (currentNode == null) {
            return false;
        }
        
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        
        if (left+right+mid >= 2) {
            this.ans = currentNode;
        }
        
        return (left+right+mid > 0);
    }
}