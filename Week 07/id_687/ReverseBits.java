package com.itliusir.bit;

/**
 * problem.190
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例 1：
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *       因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
 *
 * @author liugang
 * @date 2019-12-01
 */
public class ReverseBits {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new ReverseBits().reverseBitsTwo(n));
    }

    /**
     * method -> time O(1) space O(1)
     * 
     * 通过移位和记录来翻转
     *
     * @author liugang
     * @date 2019-12-01 18:37:03
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // 累加
            result += n & 1;
            // n 右移
            n >>>= 1;
            if (i < 31) {
                // result 左移
                result <<= 1;
            }
        }
        return result;
    }


    /**
     * method 2 -> time O(1) space O(1)
     *
     * Integer.reverse 底层实现
     *
     * @author liugang
     * @date 2019-12-01 19:00:42
     */
    public int reverseBitsTwo(int i) {
        //return Integer.reverse(n);
        // HD, Figure 7-1
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) |
                ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }
}
