package com.itliusir.bit;

import com.itliusir.util.PrintArrayUtil;

/**
 * problem.338
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * @author liugang
 * @date 2019-12-01
 */
public class CountingBits {

    public static void main(String[] args) {
        int n = 5;
        int[] result = new CountingBits().countBits(n);
        PrintArrayUtil.printArray(result);
    }

    /**
     * method 1 -> time O(n) space O(n)
     *
     * f(x) = f(x/2) + (x % 2)
     * dp[i] = dp[i >> 1] + (i & 1)
     *
     * @author liugang
     * @date 2019-12-01 20:03:39
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // f(x) = f(x/2) + (x % 2)
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    /**
     * method 2 -> time O(n) space O(n)
     *
     * dp[i] = dp[i & (i - 1)] + 1;
     *
     * @author liugang
     * @date 2019-12-01 20:08:56
     */
    public int[] countBitsTwo(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // f(x) = f(x&(x-1)) + 1
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

}
