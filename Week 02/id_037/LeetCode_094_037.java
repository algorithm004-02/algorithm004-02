// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        helper(root, result);
        return result;
    }
    private void helper(TreeNode root, List res) {
        // termination condition
        if (root == null) {
            return;
        }
        // process current logic
        helper(root.left, res);
        res.add(root.val);
        // drill down
        helper(root.right, res);
        // revert global state
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        helper(root, result);
        return result;
    }
    private void helper(TreeNode root, List res) {
        // termination condition
        if (root == null) {
            return;
        }
        // process current logic
        helper(root.left, res);
        res.add(root.val);
        // drill down
        helper(root.right, res);
        // revert global state
    }
}

// 使用栈
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        // 创建辅助栈
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        // curr不为null，或者栈不为空都应该继续
        
        while(curr != null || !stack.isEmpty()) {
            // curr 不为null，要检查节点的左树
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 左树不存在则储存当前节点，然后检查右树，如果右节点为null，且栈里面不为空，则弹出上一层左树根节点
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}