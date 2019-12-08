package com.algorithm.qinchao.homework.week02;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/30 15:37
 * @description
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_77_202 {
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>(),result);
        return result;
    }

    public void backtrack(int first, LinkedList<Integer> curr,List<List<Integer>> result) {
        if (curr.size() == k) {
            result.add(new ArrayList(curr));
        }

        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            backtrack(i + 1, curr, result);
            curr.removeLast();
        }
    }
}
