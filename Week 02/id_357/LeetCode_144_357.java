import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root != null){
            treeNodeList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
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
        List list = new Solution().preorderTraversal(treeNode);
        System.out.println(list);
    }
}
