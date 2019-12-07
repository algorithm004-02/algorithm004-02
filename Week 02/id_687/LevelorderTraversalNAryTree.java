package com.itliusir.tree;

import com.itliusir.util.Node;

import java.util.*;

/**
 * problem.429
 *
 * @author liugang
 * @date 2019-10-26
 */
public class LevelorderTraversalNAryTree {

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

        List<List<Integer>> result = new LevelorderTraversalNAryTree().levelOrderTwo(root);
        result.forEach(l -> {
            l.forEach(s -> {
                System.out.print(s + " ");
            });
            System.out.println();
        });
    }

    /**
     * method 1 -> time O(n) space O(n)
     * <p>
     * 递归
     *
     * @author liugang
     * @date 2019-10-26 18:54:44
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        doLevelOrder(result, root, 0);
        return result;
    }

    private void doLevelOrder(List<List<Integer>> result, Node root, int level) {
        if (root == null) {
            return;
        }
        if (level + 1 > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        for (Node child : root.children) {
            if (child != null) {
                doLevelOrder(result, child, level + 1);
            }
        }
    }

    /**
     * method 2 -> time O(n) space O(n)
     *
     * 迭代
     *
     * @author liugang
     * @date 2019-10-26 19:09:17
     */
    public List<List<Integer>> levelOrderTwo(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }


}
