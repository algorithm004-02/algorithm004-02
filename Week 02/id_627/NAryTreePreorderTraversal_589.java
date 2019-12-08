package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 王楠
 * @Description: N叉树的前序遍历
 * @Date: Created in 14:41 2019/10/24
 */
public class NAryTreePreorderTraversal_589 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorder01(Node root) {
        return preorder(root, new ArrayList<Integer>());
    }

    private List<Integer> preorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i), list);
        }

        return list;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorder02(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack();
        if (root == null) {
            return list;
        }
        Node curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            list.add(curr.val);
            for (int i = curr.children.size() - 1; i >=0; i--) {
                stack.push(curr.children.get(i));
            }
        }
        return list;
    }


}
