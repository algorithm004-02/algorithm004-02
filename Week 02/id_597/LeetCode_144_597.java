import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * Created by yangwenwei on 2019/10/23.
 */
public class LeetCode_144_597 {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> rlt = new ArrayList<>();
            recursion(root, rlt);
            return rlt;
        }

        private void recursion(TreeNode node, List<Integer> rlt) {
            if (node != null) {
                rlt.add(node.val);
                recursion(node.left, rlt);
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
