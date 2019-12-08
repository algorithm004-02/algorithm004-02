class Solution:
    """
    贪心算法
    从前往后跳
    """
    def canJump(self, nums: List[int]) -> bool:
        start = 0
        end = 0
        n = len(nums)
        while start <= end and end < len(nums) - 1:
            end = max(end, nums[start] + start)
            start += 1
        return end >= n - 1