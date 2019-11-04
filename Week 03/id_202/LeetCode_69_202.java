package com.algorithm.qinchao.homework.week03;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/3 16:05
 * @description 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_69_202 {
    public static int mySqrt(int num) {
        if (num <= 1) {
            return num;
        }
        long left = 0;
        long right = num / 2;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_69_202.mySqrt(2));
    }
}
