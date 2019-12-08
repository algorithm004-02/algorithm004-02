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

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            //为空输出
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            //不为空
            } else {
                //找出前驱
                TreeNode precursor = current.left;
                //第一次会成功，后续因 precursor 指向其后驱造成死循环（precursor.right != current 规避）
                while (precursor.right != null && precursor.right != current) {
                    precursor = precursor.right;
                }
                if (precursor.right == null) {
                    precursor.right = current;
                    current = current.left;
                } else {
                    precursor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}