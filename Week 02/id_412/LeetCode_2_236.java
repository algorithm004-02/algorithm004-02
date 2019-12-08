import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //分情况讨论
        //root子树中同时包含p和q, 返回root
        //root中只有p, 返回p
        //root中只有q, 返回q
        //root中既然没有p, 也没有q, 返回null
        if(root == null || root.val == p.val || root.val == q.val) return root;
        
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        // 如果左子树中同时没有p和q, 右子树中会有如下情况
        // 1. p和q都不在right中, right会返回right
        // 2. 只有p在right, 则right = p, right返回p
        // 3. 只有q在right中, 则right = q, right返回q
        // 4. p和q都在right中, right返回right本身
        
        if(l == null) return r;
        if(r == null) return l;
        return root;

    }

}
