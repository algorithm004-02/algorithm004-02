package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 王楠
 * @Description:
 * @Date: Created in 18:14 2019/10/23
 */
public class NAryTreePostorderTraversal_590 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorder01(Node root) {
        return postorder(root, new ArrayList<Integer>());
    }

    private List<Integer> postorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i), list);
        }
        list.add(root.val);
        return list;
    }

    /**
     * 栈,迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorder02(Node root) {
        LinkedList<Node> dqueue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        dqueue.add(root);
        while (!dqueue.isEmpty()) {
            Node curr = dqueue.pollLast();
            result.addFirst(curr.val);
            int len = curr.children.size();
            for (int i = 0; i < len; i++) {
                dqueue.add(curr.children.get(i));
            }
        }
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};