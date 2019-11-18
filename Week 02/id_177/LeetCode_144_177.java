package week02;

/*
144. 二叉树的前序遍历

给定一个二叉树，返回它的 前序 遍历。

示例:

    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [1,2,3]

进阶: 

    递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Will WM. Zhang
 * @since 2019-10-23 13:56
 */
public class LeetCode_144_177 {

    private TreeNode root = new TreeNode(1);
    private TreeNode t2 = new TreeNode(2);
    private TreeNode t3 = new TreeNode(3);

    public static void main(String[] args) {
        LeetCode_144_177 test = new LeetCode_144_177();

        test.root.right = test.t2;
        test.t2.left = test.t3;

        List<Integer> result = test.preorderTraversal(test.root);

        System.out.println("result: " + Arrays.toString(result.toArray()));
    }

    private List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
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
