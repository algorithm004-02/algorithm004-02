/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // List<Integer> res = new ArrayList<Integer>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if (root == null) return res;
    //     res.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
    //     return res; 
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();//每次先pop栈顶元素
            res.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return res;
    }
}

//根左右
//1. 递归法

//2. 递归法,构造栈，while(stack.isNotEmpty) pop(); if right push(right); if left push(left)