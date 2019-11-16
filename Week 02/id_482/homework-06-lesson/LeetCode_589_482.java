package com.study.homework.week02_6;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/26
 * @link
 */
public class LeetCode_589_482 {
    /**
     * 同二叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res=new ArrayList<>();
        preOrderNTree(root,res);
        return res;
    }

    private void preOrderNTree(Node node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        for (int i = 0; i < node.children.size(); i++) {
            preOrderNTree(node.children.get(i),list);
        }

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
