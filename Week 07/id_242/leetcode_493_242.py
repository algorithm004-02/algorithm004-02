#
# @lc app=leetcode id=493 lang=python3
#
# [493] Reverse Pairs
#

# @lc code=start
class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        return self.mergeSort(nums, 0, len(nums) - 1)

    def mergeSort(self, nums: List[int], left: int, right: int) -> int:
        if right <= left:
            return 0
        middle = left + ((right - left) >> 1) + 1
        count = self.mergeSort(nums, left, middle-1) + self.mergeSort(nums, middle, right)
        j = middle
        for i in range(left, middle):
            while j <= right and nums[j] * 2 < nums[i]:
                j += 1
            count += (j-middle)
        nums[left:right+1] = sorted(nums[left:right+1])
        return count

# @lc code=end

