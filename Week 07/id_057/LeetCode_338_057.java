package app.homeworkWeekSeventh;
/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (65.86%)
 * Likes:    1776
 * Dislikes: 124
 * Total Accepted:    203.5K
 * Total Submissions: 307.8K
 * Testcase Example:  '2'
 *
 * Given a non negative integer number num. For every numbers i in the range 0
 * ≤ i ≤ num calculate the number of 1's in their binary representation and
 * return them as an array.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: [0,1,1]
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * 
 * 
 * Follow up:
 * 
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 * 
 */

// @lc code=start
class Solution {
    /**
     * 如果一个数是偶数，如1110，那么1的位数和111是一样的，因此有if(num & 1 ==0) ; count(num) = count(num>>1)
     * 如果一个数是奇数，如1111，那么1的位数是1110的位数 + 1，因此有if(num & 1 == 1) ; count(num) = count(num-1) + 1
     * Time O(n)
     * Space O(n)
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int [] result = new int[num + 1];
        result[0]=0;
        for (int i = 1; i <=num; i++) {
            if ((i & 1) == 0) {
                result[i] = result[i >> 1];
            } else {
                result[i] = result[i - 1] + 1;
            }
        }
        return result;
    }
}
// @lc code=end

