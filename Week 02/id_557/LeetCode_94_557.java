//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Hash Table Stack Tree


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//思路：递归
//class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) return Collections.EMPTY_LIST;
//        List<Integer> result = new ArrayList<>();
//        traversal(root, result);
//        return result;
//    }
//
//    private void traversal(TreeNode node, List<Integer> result) {
//        if (node == null) return;
//        traversal(node.left, result);
//        result.add(node.val);
//        traversal(node.right, result);
//    }
//}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
