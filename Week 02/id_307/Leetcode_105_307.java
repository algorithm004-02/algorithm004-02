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
    private int find(int[] arr, int start, int end, int key) {
        while (start < end) {
            if (arr[start] == key) {
                return start;
            }
            start++;
        }
        return -1;
    }
    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart == pend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int rootPos = find(inorder, istart, iend, preorder[pstart]); 
        int num = rootPos - istart;
        root.left = buildTree(preorder, pstart + 1, pstart + num + 1, inorder, istart, rootPos);
        root.right = buildTree(preorder, pstart + num + 1, pend, inorder, rootPos + 1, iend);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
}