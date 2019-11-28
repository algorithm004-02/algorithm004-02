package com.itliusir.dynamic;

import java.util.Arrays;
import java.util.List;

/**
 * problem.120
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * @author liugang
 * @date 2019-11-17
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3));
        System.out.println(new Triangle().minimumTotalTwo(triangle));
    }

    /**
     * method 1 -> time O(m * n) space O(n)
     * <p>
     * dp 方程保存最近最优解
     *
     * @author liugang
     * @date 2019-11-17 19:15:56
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * method 2 -> time O(2^n) space O(n)
     * <p>
     * 递归
     *
     * @author liugang
     * @date 2019-11-17 19:25:12
     */

    public int minimumTotalTwo(List<List<Integer>> triangle) {
        return doMinimumTotal(0, 0, triangle, triangle.size(),
                new Integer[triangle.size()][triangle.size()]);
    }

    private int doMinimumTotal(int level, int c, List<List<Integer>> triangle, int row, Integer[][] mem) {
        if (mem[level][c] != null) {
            return mem[level][c];
        }
        if (level == row - 1) {
            return mem[level][c] = triangle.get(level).get(c);
        }
        int left = doMinimumTotal(level + 1, c, triangle, row, mem);
        int right = doMinimumTotal(level + 1, c + 1, triangle, row, mem);

        return mem[level][c] = Math.min(left, right) + triangle.get(level).get(c);
    }
}
