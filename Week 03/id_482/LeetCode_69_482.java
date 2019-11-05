package com.study.week3.lesson11;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/29
 * @link https://leetcode-cn.com/problems/sqrtx/
 */
public class LeetCode_69_482 {
    /**
     * 二分搜索
     * 备注：该解法完全参考大佬的解题，虽然二分的思想较简单，
     * 但是该代码的实现需要主要到部分细节
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }



    public static void main(String[] args) {
        new LeetCode_69_482().mySqrt(16);
    }
}
