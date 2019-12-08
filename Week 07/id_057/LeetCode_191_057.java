package app.homeworkWeekSeventh;
/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 *
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 * algorithms
 * Easy (45.21%)
 * Likes:    553
 * Dislikes: 445
 * Total Accepted:    296.8K
 * Total Submissions: 648.5K
 * Testcase Example:  '00000000000000000000000000001011'
 *
 * Write a function that takes an unsigned integer and return the number of '1'
 * bits it has (also known as the Hamming weight).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a
 * total of three '1' bits.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a
 * total of one '1' bit.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a
 * total of thirty one '1' bits.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, the input will be given as signed integer type and should not
 * affect your implementation, as the internal binary representation of the
 * integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 3 above the input represents the signed
 * integer -3.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * If this function is called many times, how would you optimize it?
 * 
 */

// @lc code=start
class Solution {
    // you need to treat n as an unsigned value
    /**
     * 利用n & n-1会将最后一位1变成0的特性
     * Time O(1)
     * Space O(1)
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int total = 0;
        while (n != 0) {
            total ++;
            n = n & (n - 1);
        }
        return total;
    }

    /**
     * 使用mask进行进行&运算，如果不为0则说明当前位为1
     * Time O(1)
     * Space O(1)
     * @return
     */
    private int hammingWeight_mask(int n) {
        int total = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                total ++;
            }
            mask <<= 1;
        }
        return total;
    }
}
// @lc code=end

