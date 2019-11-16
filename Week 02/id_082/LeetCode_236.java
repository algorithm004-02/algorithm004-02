/**
 *
 * LeetCode-236
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 */

public class Solution {

	/**
	 * 在树中求 两个节点的 最近公共祖先问题 转换为分别在 根节点的左子树和右子树 中求公共祖先
	 * @param root 根节点
	 * @param p    指定的 p 节点
	 * @param q    指定的 q 节点
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return root;
		if (root.val == p.val || root.val == q.val) return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) return root;
		return left == null ? right:left;
	}
}
