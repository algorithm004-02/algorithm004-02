package com.algorithm.qinchao.homework.week06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/20 19:14
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_70_202 {
    private static Map<Integer, Integer> cache = new HashMap<>();
    public static int climbStairsByDFS(int n) {
        if (n <= 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        return climbStairsByDFS(n - 1) + climbStairsByDFS(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_70_202.climbStairsByDFS(3));

    }
}
