/*
    231. 2的幂
    给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
*/

// 解法1: 利用异或运算
// 通过异或运算将n最低位的1清零后, 判断n是否为0.
// 又因为2的x次幂, x必定>0, 因此得出解法.
public class Solution {
    public bool IsPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}