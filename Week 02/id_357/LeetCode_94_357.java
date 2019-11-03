import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {
    List<Integer> treeNodeList = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root != null) {
            inorderTraversal(root.left);
            treeNodeList.add(root.val);
            inorderTraversal(root.right);
        }

        return treeNodeList;


    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = null;
        treeNode.right = treeNode1;
        treeNode1.left = treeNode2;
        List list = new Solution().inorderTraversal(treeNode);
        System.out.println(list);
    }
}
