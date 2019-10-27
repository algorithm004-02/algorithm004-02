/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start

class Solution {

    /**
     * 方法一
     */

    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return res;
    }

    /**
     * 1. 如果当前节点本身是 p 或 q 中的一个，我们会将变量 mid 标记为 true，并继续搜索左右分支中的另一个节点。 2.
     * 如果左分支或右分支中的任何一个返回 true，则表示在下面找到了两个节点中的一个。 3.
     * 如果在遍历的任何点上，左、右或中三个标志中的任意两个变为true，这意味着我们找到了节点 p 和 q 的最近公共祖先。
     */
    public boolean recurseTree(TreeNode cur, TreeNode p, TreeNode q) {

        if (cur == null) {
            return false;
        }

        int left = recurseTree(cur.left, p, q) ? 1 : 0;
        int right = recurseTree(cur.right, p, q) ? 1 : 0;
        int mid = (cur == p || cur == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            res = cur;
            return true;
        }

        return mid + left + right > 0;
    }

    /**
     * 方法二
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // root == q|| root == p , 返回root.
        if (root == null || root == p || root == q) {
            return root;
        }

        // 进入下一层递归
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        /**
         * 1. 左右都找到，则表示q、p 分别在root的左子树和右子树，则root就是最小公共祖先。 2.
         * left为空，则表示q、p都在右子树中，在右子树中查找。 3. right同理left。 4.
         */
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }

}

// @lc code=end
