package com.algorithm.qinchao.homework.week07;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/12/5 16:32
 * @description
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_231_202 {
    public boolean isPowerOfTwo(int n) {
        //2次幂必然只有一个1，n&n-1清除最低位1，清完肯定为0
        return n > 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_231_202().isPowerOfTwo(3));
        System.out.println(new LeetCode_231_202().isPowerOfTwo(8));

    }
}
