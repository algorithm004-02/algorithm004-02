/*
    120. 三角形最小路径和
    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 */

using System.Collections.Generic;

public class Solution
{
    public int MinimumTotal(IList<IList<int>> triangle)
    {
        List<int> dp = Enumerable.Repeat(0, triangle.Count + 1).ToList();

        for (int i = triangle.Count - 1; i >= 0; i--)
        {
            for (int j = 0; j < triangle[i].Count; j++)
            {
                dp[j] = Math.Min(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        return dp[0];
    }
}