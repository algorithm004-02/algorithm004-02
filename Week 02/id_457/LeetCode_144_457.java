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
    /**
        144. 二叉树的前序遍历
        迭代
        时间复杂度：访问每个节点恰好一次，时间复杂度为 O(N) ，
                    其中 N 是节点的个数，也就是树的大小。
        空间复杂度：取决于树的结构，最坏情况存储整棵树，因此空间复杂度是 O(N)。
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        if (root == null) {
            return output;
        }
        
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}