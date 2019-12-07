package com.angle.datastructure.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Autor:hash
 * Date: 2019/10/27
 * Description:
 */
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getNode(root, list);
        return list;
    }

    private void getNode(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                getNode(root.left, list);
            }
            if (root.right != null) {
                getNode(root.right, list);
            }
        }
    }
}
