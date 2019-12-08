/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.List;
//莫里斯遍历
//1.先建立根的索引
//2.访问左节点
//3.访问右节点
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        TreeNode current = root;
        while (current != null) {
            //这里访问左子树
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode precursor = current.left;
                while (precursor.right != null && precursor.right != current) {
                    precursor = precursor.right;
                }
                //这里建立中序时后继的索引
                if (precursor.right == null) {
                    precursor.right = current;
                    result.add(current.val);
                    current = current.left;
                } else {
                    //访问右子树
                    precursor.right = null;
                    current = current.right;
                }
            }
        }
        return result;
    }
}