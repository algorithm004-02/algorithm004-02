/*
 * @lc app=leetcode.cn id=300 lang=csharp
 *
 * [300] 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (43.22%)
 * Likes:    359
 * Dislikes: 0
 * Total Accepted:    38.4K
 * Total Submissions: 88.4K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4 
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 
 * 说明:
 * 
 * 
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * 
 * 
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 
 */

// @lc code=start
public class Solution
{
    public int LengthOfLIS(int[] nums)
    {
        int[] tails = new int[nums.Length];
        int res = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            int first = 0, last = res;
            while (first < last)
            {
                int mid = (first + last) / 2;
                if (tails[mid] < nums[i])
                    first = mid + 1;
                else
                    last = mid;
            }
            tails[first] = nums[i];
            if (res == last) res++;
        }
        return res;
    }
}
// @lc code=end

