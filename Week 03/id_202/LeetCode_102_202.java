package com.algorithm.qinchao.homework.week03;

import com.algorithm.qinchao.homework.week02.LeetCode_242_202;
import com.algorithm.qinchao.homework.week02.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/1 10:41
 * @description 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_102_202 {
    /**
     * bfs 时间复杂度=O(N) 每个节点访问一次且仅访问一次
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderByBFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                //获取下一次的
                getNext(curr, queue, tempList);
            }
            if (!tempList.isEmpty()) {
                result.add(tempList);
                tempList = new ArrayList<>();
            }
        }
        return result;
    }

    private static void getNext(TreeNode curr, LinkedList<TreeNode> queue, List<Integer> tempList) {
        TreeNode left = curr.left;
        TreeNode right = curr.right;
        if (left != null) {
            queue.add(left);
        }
        if (right != null) {
            queue.add(right);
        }
        tempList.add(curr.val);
    }


    /**
     * DFS 时间复杂度=O(N) 每个节点访问一次且仅访问一次
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderByDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        recursive(1, result, root);
        return result;
    }

    private static void recursive(int level, List<List<Integer>> result, TreeNode curr) {
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }
        result.get(level - 1).add(curr.val);
        if (curr.left != null) {
            recursive(level + 1, result, curr.left);
        }
        if (curr.right != null) {
            recursive(level + 1, result, curr.right);
        }
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(7, new TreeNode(5, null, null), new TreeNode(8, null, null));
        TreeNode right = new TreeNode(15, new TreeNode(13, null, null), new TreeNode(18, null, null));
        TreeNode root = new TreeNode(10, left, right);
        System.out.println(LeetCode_102_202.levelOrderByBFS(root));
        System.out.println(LeetCode_102_202.levelOrderByDFS(root));
    }
}
