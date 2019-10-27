package week2.work;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/26 12:07
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class L236 {
  /**
   * 还没完全想明白.
   * */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == p || root == q || root == null) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }


  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
