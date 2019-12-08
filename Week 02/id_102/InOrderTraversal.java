package solution;

import java.util.ArrayList;
import java.util.List;

// 中序遍历
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode tree = prepareBinaryTree(root);

        getInorderTraversal(tree);

    }

    private static void getInorderTraversal(TreeNode tree) {
        List <Integer> result  = new ArrayList<Integer>();

        inorderTraversal(tree, result);

        System.out.println("======in order===========" + result);
    }

    private static TreeNode prepareBinaryTree(TreeNode root) {
        TreeNode tree = root;
        tree.left = null;
        tree.right = new TreeNode(2);

        tree.right.right = null;
        tree.right.left = new TreeNode(3);

        return tree;

    }

    private static void inorderTraversal(TreeNode treeNode, List < Integer > result) {

        // 1.  terminate
        if (treeNode == null) {
            return;
        }


        if (treeNode.left != null) {
            inorderTraversal(treeNode.left, result);
        }

        // 2. process logic in current level
        result.add(treeNode.value);

        // 3. drill down
        if (treeNode.right != null) {
            inorderTraversal(treeNode.right, result);
        }

        // 4. reverse the current level status
    }
}