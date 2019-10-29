package com.arithmetic.arithmetic.week02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_429_657 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public void helper(Node node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());
        // fulfil the current level
        levels.get(level).add(node.val);
        // process child nodes for the next level
        for(Node rot : node.children)
        {
            if (rot != null)
                helper(rot, level + 1);
        }

    }
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}
