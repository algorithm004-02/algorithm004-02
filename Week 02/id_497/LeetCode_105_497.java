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
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TreeNode node = new TreeNode(preorder[0]);

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return getNodeVal(preorder, 0, preorder.length, inorder, 0, inorder.length);

    }

    private TreeNode getNodeVal(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) return null;
        TreeNode node = new TreeNode(preorder[pStart]);
        int leftCount = indexMap.get(preorder[pStart]) - iStart;
        node.left = getNodeVal(preorder, pStart + 1, pStart + leftCount + 1, inorder, iStart, indexMap.get(preorder[pStart]));
        node.right = getNodeVal(preorder, pStart + leftCount + 1, pEnd, inorder, indexMap.get(preorder[pStart]) + 1,
                iEnd);
        return node;
    }
}