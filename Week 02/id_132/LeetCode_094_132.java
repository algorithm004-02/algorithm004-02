//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表



//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(binarytree.TreeNode root) {
        List<Integer> intArr = new ArrayList<>();
        traversalTreeNode(root, intArr);
        return intArr;
    }

    private void traversalTreeNode(binarytree.TreeNode root, List<Integer> intArr) {
        if (root.left != null) {
            traversalTreeNode(root.left, intArr);
        }
        intArr.add(root.val);
        if (root.right != null) {
            traversalTreeNode(root.right, intArr);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
