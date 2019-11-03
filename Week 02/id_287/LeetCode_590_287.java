package com.tulane.mine;

import com.tulane.base.Node;
import com.tulane.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Postorder {

    /**
     * TODO 未完全理解, 也并未提交力扣
     * 第三种 栈 广度优先
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = (Node) stack.pop();
            //逆序加入数组 加入顺序, 根 -> 右 -> 左
            list.add(0, node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }

    /**
     * TODO 未写出
     * 第二种 栈 深度优先
     *
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        while (root != null) {
            stack.push(root);
            root = root.children.get(0);
        }
        TreeNode node = (TreeNode) stack.pop();
        return list;
    }

    /**
     * 第一种 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        recursion(root, list);
        return list;
    }

    private void recursion(Node root, List<Integer> list) {
        List<Node> nodes = root.children;
        if (nodes != null && nodes.size() > 0) for (Node node : nodes) recursion(node, list);
        list.add(root.val);
    }
}
