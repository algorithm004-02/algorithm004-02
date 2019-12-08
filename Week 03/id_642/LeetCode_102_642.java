package week3.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/28 21:59
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 */
public class L102 {
  /**
   * BFS
   * */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    /** 记录当前层的元素 */
    Deque<TreeNode> curDeque = new ArrayDeque<>();
    /** 记录下一层的元素 */
    Deque<TreeNode> downDeque = new ArrayDeque<>();
    /** 用来储存当前层的元素，用于输出 */
    List<Integer> valList = new ArrayList<>();
    curDeque.add(root);
    while (!curDeque.isEmpty()) {
      TreeNode treeNode = curDeque.removeFirst();
      valList.add(treeNode.val);
      if (treeNode.left != null) {
        downDeque.addLast(treeNode.left);
      }
      if (treeNode.right != null) {
        downDeque.addLast(treeNode.right);
      }
      /**  这一层打印结束了，清空记录 */
      if (curDeque.isEmpty()) {
        curDeque = downDeque;
        list.add(valList);
        valList = new ArrayList<>();
        downDeque = new ArrayDeque<>();
      }
    }
    return list;
  }

  /**
   * dfs
   * */
  public List<List<Integer>> dfsLevelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    dfs(list, root, 0);
    return list;
  }

  private void dfs(List<List<Integer>> list, TreeNode root, int height) {
    if (root == null) {
      return;
    }
    if (height >= list.size()) {
      list.add(new ArrayList<>());
    }
    list.get(height).add(root.val);
    dfs(list, root.left, height + 1);
    dfs(list, root.right, height + 1);
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
