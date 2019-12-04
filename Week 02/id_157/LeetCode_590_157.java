package com.kaiyun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithms
 * @description:
 * @author: Kaiyun
 * @create: 2019-10-27 16:14
 **/
public class LeetCode_590_157 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        helper(root, result);

        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) return;
        for (Node node: root.children) {
            helper(node,result);
        }
        result.add(root.val);
    }
}
