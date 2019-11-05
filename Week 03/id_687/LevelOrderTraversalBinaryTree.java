package com.itliusir.tree;

import com.itliusir.util.TreeNode;

import java.util.*;

/**
 * problem.102
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *     1
 *  2    3
 *4         5
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author liugang
 * @date 2019-10-29
 */
public class LevelOrderTraversalBinaryTree {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        List<List<Integer>> lists = new LevelOrderTraversalBinaryTree().levelOrderThree(root);
        lists.forEach(
                list -> {
                    list.forEach(
                            integer -> System.out.print(integer + " ")
                    );
                    System.out.println();
                }
        );
    }

    /**
     * method 1 -> time O(n) space O(n)
     *
     * 使用队列迭代(自己lowb实现)
     *
     * @author liugang
     * @date 2019-10-30 00:23:37
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(root));
        while (!queue.isEmpty()) {
            List<TreeNode> list = queue.poll();
            List<Integer> res = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode node : list) {
                res.add(node.val);
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }
            if (!nextLevelNodes.isEmpty()) {
                queue.add(nextLevelNodes);
            }
            result.add(res);
        }
        return result;
    }

    /**
     * method 2 -> time O(n) space O(n)
     *
     * 递归解法
     *
     * @author liugang
     * @date 2019-10-30 00:39:42
     */
    public List<List<Integer>> levelOrderTwo(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        doLevelOrder(result, root, 0);
        return result;
    }

    private void doLevelOrder(List<List<Integer>> result, TreeNode root, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            doLevelOrder(result, root.left, level + 1);
        }
        if (root.right != null) {
            doLevelOrder(result, root.right, level + 1);
        }
    }

    /**
     * method 3 -> time O(n) space O(n)
     *
     * 迭代老司机写法
     *
     * @author liugang
     * @date 2019-10-30 00:47:14
     */
    public List<List<Integer>> levelOrderThree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
    }

}
