package com.lich.springboot.lichdemo.homework.six.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        checkNode(root, res);
        return res;
    }

    public void checkNode(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                checkNode(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                checkNode(root.right, res);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(root));
    }
}
