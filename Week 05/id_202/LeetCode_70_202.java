package com.algorithm.qinchao.homework.week05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/12 18:39
 * @description
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_70_202 {
    /**
     * 分治  子问题：sub(n) = sub(n-1)+sub(n-2)
     * @param n
     * @return
     */
    public static int climbStairsByDivision(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return recursive(n, cache);
    }

    private static int recursive(int n, Map<Integer, Integer> cache) {
        if (n <= 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = recursive(n - 1, cache) + recursive(n - 2, cache);
        cache.put(n, result);
        return result;
    }

    /**
     * 子问题：d(n) = d(n-1)+d(n-2)
     * 状态数组：a[n]
     * dp方程 = d[i] = d[i-1]+d[i-2]
     * @param n
     * @return
     */
    public static int climbStairsByDp(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }


    /**
     * 子问题：d(n) = d(n-1)+d(n-2)
     * 状态数组：a[n]-------》简化为最后的临时变量记录最后状态
     * dp方程 = d[i] = d[i-1]+d[i-2]
     * @param n
     * @return
     */
    public static int climbStairsByDpSimple(int n) {
        int s1 = 1;
        int s2 = 2;
        int s3 = 3;
        for (int i = 3; i <= n; i++) {
            s3 = s1 + s2;
            s1 = s2;
            s2 = s3;
        }
        return s3;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_70_202.climbStairsByDivision(5));
        System.out.println(LeetCode_70_202.climbStairsByDp(5));
        System.out.println(LeetCode_70_202.climbStairsByDpSimple(5));

    }
}
