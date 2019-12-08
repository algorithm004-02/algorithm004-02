package com.kaiyun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiyun on 2019/10/22.
 */
public class LeetCode_94_157 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        treeTraversal(root,result);
        return result;
    }

    private void treeTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                treeTraversal(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                treeTraversal(root.right, result);
            }
        }
    }



}
