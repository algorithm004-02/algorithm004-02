class Solution:
    
    # 将 dp 数组定义为：以 nums[i] 结尾的最长上升子序列的长度
    # 那么题目要求的，就是这个 dp 数组中的最大者
    # 以数组  [10, 9, 2, 5, 3, 7, 101, 18] 为例
    # dp 的值： 1  1  1  2  2  3  4    4

    def lengthOfLIS(self, nums):
        size = len(nums)
        # 特判
        if size <= 1:
            return size
        
        dp = [1] * size
        for i in range(1, size):
            for j in range(i):
                if nums[i] > nums[j]:
                    # + 1 的位置不要加错了
                    dp[i] = max(dp[i], dp[j] + 1)
        # 最后要全部一看遍，取最大值
        return max(dp)