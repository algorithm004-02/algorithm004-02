package com.tulane.leetcode.one;

import java.util.List;

/**
 * 三角形最小路径和
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_120 {

    /**
     * 思考:
     * 自底向上 DP
     * 重复性(分治): problem(i,j) = min(subproblem(i+1,j), subproblem(i+1,j+1)) + a[i,j]
     * 定义状态数组: f[i,j]
     * DP方程: f[i,j] = min(f[i+1, j], f[i+1, j+1]) + a[i,j]
     * <p>
     * 做法:
     * 状态数组用triangle的最下层的大小的一维数组
     * 两层循环遍历, 层数由下往上, 由左至右
     * 使用DP方程
     *
     * 隐性条件: 0层1个, 1层两个, 2层三个 ...
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] db = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                db[j] = Math.min(db[j], db[j+1]) + triangle.get(i).get(j);
            }
        }
        return db[0];
    }
}
