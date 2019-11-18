//Given a binary tree, return the postorder traversal of its nodes' values. 
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
//Output: [3,2,1]
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
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root == null) return Collections.EMPTY_LIST;
//        List<Integer> result = new ArrayList<>();
//        traversal(root, result);
//        return result;
//    }
//
//    private void traversal(TreeNode node, List<Integer> result) {
//        if (node == null) return;
//        traversal(node.left, result);
//        traversal(node.right, result);
//        result.add(node.val);
//    }
//}


//思路：循环遍历，使用一个栈来保存中间结果
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            //先将父节点压入栈中
            while (!isLeaf(cur)) {
                stack.push(cur);
                cur = cur.left;
            }
            //如果是左孩子、右孩子就直接遍历
            if (cur != null) result.add(cur.val);
            //如果是右孩子就从栈中取出父节点遍历
            //如果父节点还是右孩子就继续循环遍历
            while (!stack.isEmpty() && cur == stack.peek().right) {
                cur = stack.pop();
                result.add(cur.val);
            }
            //如果是左孩子就继续遍历右孩子
            if (stack.isEmpty()) {
                cur = null;
            } else {
                cur = stack.peek().right;
            }

        }
        return result;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) return true;
        return node.left == null && node.right == null;

    }
}

//leetcode submit region end(Prohibit modification and deletion)
