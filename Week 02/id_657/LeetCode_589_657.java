package com.arithmetic.arithmetic.week02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_657 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            result.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return result;
    }


}
