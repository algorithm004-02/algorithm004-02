# 300. [最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)

## 题目

给定一个无序的整数数组，找到其中最长上升子序列的长度。

==示例 1：==

```
输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
```

## 动态规划

> 两层遍历，当前 i 的最长上升子序长度，是 i 之前所有的最长加1。动态方程：dp[i] = Max(dp[i], dp[j]+1)

```
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < dp.length; i++) dp[i] = 1;
        int max = dp[0];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        
        return max;
    }
}
```


