import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * Created by yangwenwei on 2019/10/22.
 */
public class LeetCode_94_597 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rlt = new ArrayList<>();
            recursion(root, rlt);
            return rlt;

        }

        private void recursion(TreeNode node, List<Integer> rlt) {
            if (node != null) {
                recursion(node.left, rlt);
                rlt.add(node.val);
                recursion(node.right, rlt);
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
