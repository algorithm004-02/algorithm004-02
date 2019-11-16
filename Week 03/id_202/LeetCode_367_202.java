package com.algorithm.qinchao.homework.week03;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/3 16:18
 * @description 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LeetCode_367_202 {
    public static boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        long left = 0;
        long right = num >>> 1;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left * left == num;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_367_202.isPerfectSquare(1));
    }
}
