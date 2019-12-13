package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: 王楠
 * @Description:
 * @Date: Created in 16:12 2019/10/25
 */
public class BinaryTreeLevelOrderTraversal_102 {

    List<List<Integer>> list = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_01(TreeNode root) {
        if (root == null) {
            return list;
        }
        helper(root, 0);
        return list;
    }

    private void helper(TreeNode root, int level) {
        if (level == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_02(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            list.add(new ArrayList<Integer>());
            int queue_length = queue.size();
            for (int i = 0; i < queue_length; i++) {
                TreeNode node = queue.remove();
                list.get(level).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return list;
    }

}
