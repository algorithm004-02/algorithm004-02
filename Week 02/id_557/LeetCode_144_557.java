//Given a binary tree, return the preorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree


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
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) return Collections.EMPTY_LIST;
//        List<Integer> result = new ArrayList<>();
//        traversal(root, result);
//        return result;
//    }
//
//    private void traversal(TreeNode node, List<Integer> result) {
//        if (node == null) return;
//        result.add(node.val);
//        traversal(node.left, result);
//        traversal(node.right, result);
//    }
//}

//思路：循环遍历，使用一个栈来保存中间结果
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.add(p.val); // 在遍历左孩子之前先加入
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
