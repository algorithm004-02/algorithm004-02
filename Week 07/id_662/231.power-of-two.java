/**
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
 * <p>
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}