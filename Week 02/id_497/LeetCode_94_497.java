/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        getNodeVal(root, integers);
        return integers;

    }

    private void getNodeVal(TreeNode node, List<Integer> integers) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            integers.add(node.val);
            return;
        }
        getNodeVal(node.left, integers);
        integers.add(node.val);
        getNodeVal(node.right, integers);
    }

}