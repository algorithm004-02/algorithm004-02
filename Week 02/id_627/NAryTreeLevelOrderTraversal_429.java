package com.example.demo.leetcode;

import java.util.*;

/**
 * @Author: 王楠
 * @Description: N叉树的层序遍历
 * @Date: Created in 14:41 2019/10/24
 */
public class NAryTreeLevelOrderTraversal_429 {
    public static void main(String[] args) {

    }


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_01(Node root) {
        if (root == null) {
            return list;
        }
        return leverOrder(root, 0);
    }

    List<List<Integer>> list = new ArrayList<>();

    private List<List<Integer>> leverOrder(Node root, int level) {
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        level++;
        for (int i = 0; i < root.children.size(); i++) {
            leverOrder(root.children.get(i), level);
        }
        return list;
    }


    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_02(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<Node>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int queue_length = queue.size();
            if (list.size() == level) {
                list.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < queue_length; i++) {
                Node node = queue.remove();
                list.get(level).add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    queue.add(node.children.get(j));
                }
            }
            level++;
        }
        return list;
    }


}
