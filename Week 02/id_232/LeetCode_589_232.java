package src.main.java.com.fans.algorithm00402.week2.homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * */
public class LeetCode_589_232 {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /** 1. 递归法 O(n) O(n) */
//    public List<Integer> preorder(Node root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
//    }
//
//    private void helper(Node root, List<Integer> res) {
//        if (root != null) {
//            res.add(root.val);
//            for (Node node : root.children) {
//                helper(node, res);
//            }
//        }
//    }

    /** 2. 迭代法 O(n) O(n)
     * - 使用stack辅助
     * - 先输出根
     * - 然后从后往前把children入栈
     * */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        if (node != null) stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i --) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }

}
