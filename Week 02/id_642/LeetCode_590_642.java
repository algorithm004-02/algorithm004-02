package week2.work;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/23 19:31
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class L590 {

  List<Integer> list = new ArrayList<>();

  /**
   * 递归.
   * */
  public List<Integer> postorder(Node root) {
    if (root == null) {
      return list;
    }
    for (int i = 0; i < root.children.size(); i++) {
      postorder(root.children.get(i));
    }
    list.add(root.val);
    return list;
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
