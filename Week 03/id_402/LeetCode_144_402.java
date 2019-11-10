Thinking:
使用递归，熟记二叉树的前中后序遍历。

Code:
java

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        DLR(root, list);
        return list;
    }

    private void DLR (TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            this.DLR(node .left, list);
            this.DLR(node.right, list);
        }
    }
}

