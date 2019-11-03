package com.itliusir.tree;

import com.itliusir.util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * problem.589
 * <p>
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @author liugang
 * @date 2019-10-26
 */

public class PreorderTraversalNAryTree {

    public static void main(String[] args) {
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        List<Node> node3Child = new ArrayList<>();
        node3Child.add(node5);
        node3Child.add(node6);
        Node node3 = new Node(3, node3Child);
        List<Node> node1Child = new ArrayList<>();
        node1Child.add(node3);
        node1Child.add(node2);
        node1Child.add(node4);
        Node root = new Node(1, node1Child);

        List<Integer> result = new PreorderTraversalNAryTree().preorderTwo(root);
        result.forEach(integer -> System.out.println(integer));
    }

    /**
     * method 1 -> time O(n * size) space O(n)
     * <p>
     * 递归
     *
     * @author liugang
     * @date 2019-10-26 17:58:26
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPreorder(result, root);
        return result;
    }

    private void doPreorder(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node child : root.children) {
            doPreorder(result, child);
        }
    }

    /**
     * method 2 -> time O(n * size) space O(n)
     * @author liugang
     * @date 2019-10-26 18:12:43
     */
    public List<Integer> preorderTwo(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            result.add(node.val);
            List<Node> children = node.children;
            int size = children.size();
            for (int i = size - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return result;
    }
}
