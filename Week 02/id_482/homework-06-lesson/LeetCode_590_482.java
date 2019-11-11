package com.study.homework.week02_6;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/26
 * @link
 */
public class LeetCode_590_482 {

    /**
     * 解法一 递归，同二叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res=new ArrayList<>();
        postOrderNTree(root,res);
        return res;
    }

    private void postOrderNTree(Node node, List<Integer> list) {
        if (node == null)
            return;
        for (int i = 0; i < node.children.size(); i++) {
            postOrderNTree(node.children.get(i),list);
        }
        list.add(node.val);
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
