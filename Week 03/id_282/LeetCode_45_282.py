class Solution:
    """
    贪心算法
    从一个位置跳到它能跳到的最远位置之间的都只需要一步!
    所以,如果一开始都能跳到,后面再跳到的肯定步数要变多!
    """
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1 : return 0
        dp = [0] * n
        for i in range(n):
            for j in range(nums[i], 0, -1):
                if i + j >= n - 1 : return dp[i] + 1
                elif dp[i + j] == 0:
                    dp[i + j] = dp[i] + 1
                else:
                    break