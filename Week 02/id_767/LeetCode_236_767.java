package algorithm.LeetCode;

import algorithm.util.TreeNode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _236_LowestCommonAncestor {

  /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null )
          throw new RuntimeException("root is illegal! "); //不符合条件时，throw一个自定义异常抛出，提示原因
        //回溯必须要有双向指针

  }*/


 // 方法1：
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65225/4-lines-C%2B%2BJavaPythonRuby
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
  }

// 方法2：调整判断逻辑分类 主体逻辑不变
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/224225/Java-9ms
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null ) {
      return root;
    }
    if (root == p || root == q) {
      return root;
    }
    TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
    TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
    if (leftLCA != null && rightLCA != null) return root;  // current root is the LCA of p and q
    if (leftLCA == null && rightLCA == null) return null;  // LCA of p and q is not in current branch
    return leftLCA == null ? rightLCA : leftLCA;  // LCA of
  }

}
