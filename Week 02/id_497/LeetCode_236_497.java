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
    LinkedList<TreeNode> tree1;
    LinkedList<TreeNode> tree2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getTreeNode(root, p, q, new LinkedList<>());
        tree1.retainAll(tree2);
        return tree1.get(tree1.size() - 1);
    }

    public void getTreeNode(TreeNode node, TreeNode p, TreeNode q, LinkedList<TreeNode> tree) {
        if (node == null) {
            return;
        }
        tree.add(node);
        if (node == p) {
            tree1 = new LinkedList<>(tree);
        }
        if (node == q) {
            tree2 = new LinkedList<>(tree);
        }
        getTreeNode(node.left, p, q, tree);
        getTreeNode(node.right, p, q, tree);

        tree.removeLast();
    }
}