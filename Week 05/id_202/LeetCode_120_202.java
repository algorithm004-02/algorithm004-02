package com.algorithm.qinchao.homework.week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/12 19:08
 * @description 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_120_202 {
    /**
     * 子问题：f(i,j) = min(f(i+1,j),f(i+1,j+1))+value(i,j)
     *
     * @param triangle
     * @return
     */
    public static int minimumTotalByDivision(List<List<Integer>> triangle) {
        int levelMax = triangle.size();
        Integer[][] cache = new Integer[levelMax][levelMax];
        return recursive(0, 0, cache, levelMax, triangle);
    }

    private static int recursive(int level, int column, Integer[][] cache, int levelMax, List<List<Integer>> triangle) {
        if (cache[level][column] != null) {
            return cache[level][column];
        }
        //到最后一层了
        if (level == levelMax - 1) {
            return cache[level][column] = triangle.get(level).get(column);
        }

        return cache[level][column] = Math.min(
                recursive(level + 1, column, cache, levelMax, triangle),
                recursive(level + 1, column + 1, cache, levelMax, triangle)) + triangle.get(level).get(column);
    }


    /**
     * 子问题：subP(i,j) = min(sub(i+1,j),sub(i+1,j+1))+ sub(i,j)
     * 状态数组：f[i,j]
     * dp方程：f[i,j] = min(f[i+1,j],f[i+1,j+1])+ value[i,j]
     *
     * @param triangle
     * @return
     */
    public static int minimumTotalByDp(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[] result = new int[level + 1];
        for (int i = level - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //只取当前行的最小值
                result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
            }
        }
        return result[0];
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(0, Arrays.asList(new Integer[]{2}));
        triangle.add(1, Arrays.asList(new Integer[]{3, 4}));
        triangle.add(2, Arrays.asList(new Integer[]{6, 5, 7}));
        triangle.add(3, Arrays.asList(new Integer[]{4, 1, 8, 3}));
        System.out.println(LeetCode_120_202.minimumTotalByDivision(triangle));
        System.out.println(LeetCode_120_202.minimumTotalByDp(triangle));

    }
}
