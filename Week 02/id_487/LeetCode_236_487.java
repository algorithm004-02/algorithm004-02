class LeetCode_236_487{
    /***
     *
     * 236题
     *
     * 二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */

    TreeNode ansNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return ansNode;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        //1。递归终止条件
        if (root == null) {
            return false;
        }
        //2。处理当前层 3。下到下一层
        int left = recurseTree(root.left, p, q) ? 1 : 0;   //如果当前root的左边存在目标节点，记录1
        int right = recurseTree(root.right, p, q) ? 1 : 0; //如果当前root的右边存在目标节点，记录1
        int mid = (root == p || root == q) ? 1 : 0;        //如果当前层root就是目标节点p或者q，记录为1
        if (left + right + mid >= 2) {                     //如果当前层的目标节点大于等于两个，那么当前root就是公共祖先
            this.ansNode = root;
        }
        return left + right + mid > 0;                     //大于0，存在目标节点
    }

}