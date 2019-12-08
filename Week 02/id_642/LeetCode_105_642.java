package week2.work;


/**
 * @Author: xiang1.li
 * @Date: 2019/10/26 16:16
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class L105 {
  /**
   * 1、先序遍历第一个节点为根节点.
   * 2、在中序遍历中找到跟节点，左边是左子树，右边是右子树.
   * 3、不断递归构造子树，最后就还原了一棵树
   * */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      return null;
    }
    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder,
        0, inorder.length - 1);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
      int[] inorder, int inStart, int inEnd) {
    // 终止条件
    if (preStart > preEnd) {
      return null;
    }
    // 逻辑处理
    int value = preorder[preStart];
    int mid = getMid(inorder, inStart, inEnd, value);
    TreeNode root = new TreeNode(value);
    // 左右子树的元素个数
    int leftNum = mid - inStart;
    int rightNum = inEnd - mid;
    // 递归
    root.left = buildTree(preorder, preStart + 1, preStart + leftNum, inorder, inStart, mid - 1);
    root.right = buildTree(preorder, preEnd - rightNum + 1, preEnd, inorder, mid + 1, inEnd);
    return root;
  }

  /**
   * 在中序数组中找到根的位置.
   * */
  public int getMid(int[] inorder, int inStart ,int inEnd, int value) {
    for (int i = inStart; i <= inEnd ; i++) {
      if (inorder[i] == value) {
        return i;
      }
    }
    return -1;
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
