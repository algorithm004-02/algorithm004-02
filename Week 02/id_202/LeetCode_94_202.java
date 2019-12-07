package com.algorithm.qinchao.homework.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/30 10:38
 * @description 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_94_202 {
    public List<Integer> inorderTraversalByRecursive(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursive(root.left, result);
            result.add(root.val);
            recursive(root.right, result);
        }
    }

    public List<Integer> inorderTraversalByStack(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            //后退到有孩子的地方再来
            curr = curr.right;
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode_94_202 leetCode_94_202 = new LeetCode_94_202();
        TreeNode left = new TreeNode(7, new TreeNode(5, null, null), new TreeNode(8, null, null));
        TreeNode right = new TreeNode(15, new TreeNode(13, null, null), new TreeNode(18, null, null));
        TreeNode tree = new TreeNode(10, left, right);
        leetCode_94_202.inorderTraversalByRecursive(tree);
        System.out.println(leetCode_94_202.inorderTraversalByStack(tree));
    }
}
