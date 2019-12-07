package com.itliusir.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * problem.77
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author liugang
 * @date 2019-10-27
 */
public class Combinations {

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> result = new Combinations().combine(n, k);
        result.forEach(list -> {
            list.forEach(
                    integer -> System.out.print(integer + " ")
            );
            System.out.println();
        });
    }

    /**
     * method 1 -> time O(n * k) space O(n)
     *
     * 泛型递归
     *
     * @author liugang
     * @date 2019-10-27 22:48:00
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        doCombine(result, n , k , 1, new ArrayList<Integer>());
        return result;
    }

    private void doCombine(List<List<Integer>> result, int n, int k, int start, List<Integer> comb) {
        // terminator
        if (k == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        // process
        for (int i = start; i <= n - k + 1; i++) {
            comb.add(i);
            // fill one -> (sizeof(k) - 1)
            // drill down
            doCombine(result, n, k - 1, i + 1 , comb);
            // reverse curr level status
            comb.remove(comb.size() - 1);
        }
    }
}
