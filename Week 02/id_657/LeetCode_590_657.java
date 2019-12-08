package com.arithmetic.arithmetic.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_590_657 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> nums = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        list.add(root);
        int i=0;
        while (i<list.size()) {
            Node node = list.get(i);
            if(node!=null){
                List<Node> child = node.children;
                if(child!=null&&child.size()>0){
                    for(int j=child.size()-1;j>-1;j--){
                        list.add(i+child.size()-j,child.get(j));
                    }
                }
            }else {
                return nums;
            }
            i++;
        }
        for (Node node : list) {
            nums.add(0,node.val);
        }
        return nums;
    }


}
