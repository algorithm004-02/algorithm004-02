package src.main.java.com.fans.algorithm00402.week2.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * */
public class LeetCode_429_232 {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /** 1. 使用队列进行遍历  O(n) O(n)
     *  - 将root放入队列中
     *  - 输入root的同时，把子节点入队
     * */
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<Node> queue = new LinkedList<>();
//        Node node = root;
//        if (node != null) queue.add(node);
//        while (!queue.isEmpty()) {
//            int count = queue.size();
//            List<Integer> tempRes = new ArrayList<>();
//            while (count -- > 0) {
//                node = queue.poll();
//                tempRes.add(node.val);
//                for (Node itemNode : node.children) {
//                    queue.add(itemNode);
//                }
//            }
//            res.add(tempRes);
//        }
//        return res;
//    }

    /**
     * 2. 递归 O(n)  O(n)
     * - 维护一个递归的深度
     * - 用深度将遍历的值分组
     * - 执行前序遍历即可
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(Node node, int depth, List<List<Integer>> res) {
        if (node != null) {
            if (depth > res.size() - 1) res.add(new ArrayList<>());
            res.get(depth).add(node.val);
            for (Node itemNode : node.children) {
                helper(itemNode, depth + 1, res);
            }
        }
    }

}
