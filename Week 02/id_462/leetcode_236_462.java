/**
 二叉树的最近公共祖先
 */
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (hasContains(p,q)) {
            return p;
        }
        if (hasContains(q,p)) {
            return q;
        }
        TreeNode tp = p;
        while (!hasContains(tp, q)) {
            tp = findParent(root,tp);
        }
        return tp;
    }

    private TreeNode findParent(TreeNode root, TreeNode tp) {
        if (root != null) {
            if (root.left == tp || root.right == tp) {
                return root;
            }
            TreeNode resultlft = findParent(root.left,tp);
            TreeNode resultRight  = findParent(root.right,tp);
            return resultlft ==null? resultRight :resultlft;
        }
        return null;
    }

    private boolean hasContains(TreeNode p, TreeNode q) {
        if (p!=null) {
            if (p.left ==q || p.right==q) {
                return true;
            }
            return hasContains(p.left,q) || hasContains(p.right,q);
        }
        return false;
    }
}