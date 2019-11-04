package week2.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/22 19:32
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 */
public class L94 {

  List<Integer> list = new ArrayList<>();

  /**
   * 中序遍历递归算法.
   * */
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return list;
    }
    inorderTraversal(root.left);
    list.add(root.val);
    inorderTraversal(root.right);
    return list;
  }

  /**
   * 遍历，借用栈.
   * 遍历一个节点，先将所有左节点入栈，出栈时访问遍历节点的右子树，循环处理下去
   * */
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> newList = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.add(cur);
        cur = cur.left;
      }
      TreeNode treeNode = stack.pop();
      newList.add(treeNode.val);
      cur = cur.right;
    }
    return newList;
  }

  static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
  }
}


