class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if(currentNode == null) return false;
        
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;//左子树遍历
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;//右子树遍历,
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (mid + left + right >= 2) {//如果大于2，那么左右子树各包含了p,q，当前结点就是
            this.ans = currentNode;
        }
        return (left + right + mid) > 0;//只要找到过至少一个，肯定大于0
    }
}