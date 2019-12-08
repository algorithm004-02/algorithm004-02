package com.algorithm.qinchao.homework.week03;

import com.algorithm.qinchao.homework.week02.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/1 16:22
 * @description 您需要在二叉树的每一行中找到最大的值。
 * 示例：
 * 输入:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_515_202 {
    /**
     * bfs 时间复杂度=O(N) 每个节点访问一次且仅访问一次
     *
     * @param root
     * @return
     */
    public static List<Integer> largestValuesByBFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                max = Math.max(curr.val, max);
                getNext(curr, queue);
            }
            result.add(max);
        }
        return result;
    }

    private static void getNext(TreeNode curr, LinkedList<TreeNode> queue) {
        if (curr.left != null) {
            queue.add(curr.left);
        }
        if (curr.right != null) {
            queue.add(curr.right);
        }
    }

    /**
     * dfs 时间复杂度=O(N) 每个节点访问一次且仅访问一次
     *
     * @param root
     * @return
     */
    public static List<Integer> largestValuesByDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        recursive(1, result, root);
        return result;
    }

    private static void recursive(int level, List<Integer> result, TreeNode curr) {
        if (curr == null) {
            return;
        }
        if (result.size() >= level) {
            result.set(level - 1, Math.max(result.get(level - 1), curr.val));
        } else {
            result.add(level - 1, curr.val);
        }
        if (curr.left != null) {
            recursive(level + 1, result, curr.left);
        }
        if (curr.right != null) {
            recursive(level + 1, result, curr.right);
        }

    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3, new TreeNode(5, null, null), new TreeNode(3, null, null));
        TreeNode right = new TreeNode(2, null, new TreeNode(9, null, null));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(LeetCode_515_202.largestValuesByBFS(root));
        System.out.println(LeetCode_515_202.largestValuesByDFS(root));
    }
}
