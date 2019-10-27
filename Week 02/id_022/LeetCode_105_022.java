//[105]从前序与中序遍历序列构造二叉树
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

import java.util.HashMap;
import java.util.Map;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private int[] preorder;
    private int preIndex = 0;
    private Map<Integer, Integer> inIndexes = new HashMap<>();

    /**
     * 分治
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inIndexes.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1);
    }

    private TreeNode buildTree(int idxMin, int idxMax) {

        if (idxMin > idxMax) {
            return null;
        }

        int root = preorder[preIndex];
        TreeNode node = new TreeNode(root);
        preIndex++;

        int inIdx = inIndexes.get(root);
        node.left = buildTree(idxMin, inIdx - 1);
        node.right = buildTree(inIdx + 1, idxMax);
        return node;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        
    }
}