package com.itliusir.tree;

import com.itliusir.util.Node;

import java.util.*;

/**
 * problem.590
 * <p>
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @author liugang
 * @date 2019-10-26
 */
public class PostorderTraversalNAryTree {

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

        List<Integer> result = new PostorderTraversalNAryTree().postorderTwo(root);
        result.forEach(integer -> System.out.println(integer));
    }

    /**
     * method 1 -> time O(n * size) space O(n)
     * <p>
     * 递归解法
     *
     * @author liugang
     * @date 2019-10-26 17:04:17
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPostOrder(result, root);
        return result;
    }

    private void doPostOrder(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            doPostOrder(result, child);
        }
        result.add(root.val);
    }

    /**
     * method 2 -> time O(n * size * log n) space O(n)
     *
     * @author liugang
     * @date 2019-10-26 17:30:49
     */
    public List<Integer> postorderTwo(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
