/*
 * @lc app=leetcode.cn id=231 lang=csharp
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (46.80%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    37.4K
 * Total Submissions: 79.6K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */

// @lc code=start
public class Solution
{
    public bool IsPowerOfTwo(int n)
    {
        if (n <= 0)
            return false;

        if ((n & (n - 1)) == 0)
            return true;
        return false;
    }
}
// @lc code=end

// public class Solution
// {
//     public bool IsPowerOfTwo(int n)
//     {
//         if (Math.Log(n, 2) == (int)Math.Log(n, 2))
//             return true;
//         return false;
//     }
// }