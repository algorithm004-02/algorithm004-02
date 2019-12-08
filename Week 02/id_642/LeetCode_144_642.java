package week2.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @Author: xiang1.li
 * @Date: 2019/10/22 23:26
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
 *
 */
public class L144 {

  List<Integer> list = new ArrayList<>();

  /**
   * 递归写法.
   * */
  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) {
      return list;
    }
    list.add(root.val);
    preorderTraversal(root.left);
    preorderTraversal(root.right);
    return list;
  }

  /**
   * 遍历写法，借助栈.
   * */
  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> newList = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) {
      return newList;
    }
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode treeNode = stack.pop();
      newList.add(treeNode.val);
      if (treeNode.right != null) {
        stack.push(treeNode.right);
      }
      if (treeNode.left != null) {
        stack.push(treeNode.left);
      }
    }
    return newList;
  }

  static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
  }
}
