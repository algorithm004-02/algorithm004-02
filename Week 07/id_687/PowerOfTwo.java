package com.itliusir.bit;

/**
 * problem.231
 * <p>
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * <p>
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 * <p>
 * 输入: 218
 * 输出: false
 *
 * @author liugang
 * @date 2019-12-01
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        int n = 32;
        System.out.println(new PowerOfTwo().isPowerOfTwoSecond(n));
    }

    /**
     * method 1 -> time O(1) space O(1)
     * <p>
     * 我们都知道2的幂次方的数字的高位都是1，-1的话 低位都是1，做与计算都是0
     *
     * @author liugang
     * @date 2019-12-01 17:44:25
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * method 2 -> time O(1) space O(1)
     *
     * 求最接近自己的2次幂(参考HashMap)，然后判断是否相等
     *
     * @author liugang
     * @date 2019-12-01 17:50:12
     */
    public boolean isPowerOfTwoSecond(int n) {
        return n == tableSizeFor(n);
    }

    final int MAXIMUM_CAPACITY = 1 << 30;

    private final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
