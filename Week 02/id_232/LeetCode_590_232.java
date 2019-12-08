package src.main.java.com.fans.algorithm00402.week2.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
*  N叉树的后序遍历
*
* 给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

 



 

返回其后序遍历: [5,6,3,2,4,1].
*
* */
public class LeetCode_590_232 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /** 1、递归 O(n) O(n) */
//    public List<Integer> postorder(Node root) {
//        List<Integer> res = new ArrayList(){};
//        helper(root, res);
//        return res;
//    }
//
//    private void helper(Node node, List<Integer> res) {
//        if (node != null) {
//            for (Node sub : node.children) {
//                helper(sub, res);
//            }
//            res.add(node.val);
//        }
//    }

    /** 2、迭代 O(n)  O(n)
    *  - 使用stack
    *  - 中-右-左的方式访问所有节点
    *  - 反序则就是答案
    * */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList(){};
        Stack<Node> stack = new Stack<>();
        Node node = root;
        if (node != null) stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.val);
            for (int i = 0; i < node.children.size(); i ++) {
                stack.push(node.children.get(i));
            }
        }
        Collections.reverse(res);
        return res;
    }
}
