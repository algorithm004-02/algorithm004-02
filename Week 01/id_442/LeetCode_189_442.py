# https://leetcode-cn.com/problems/rotate-array/submissions/

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        self.reversed(nums, 0, len(nums) - 1)
        self.reversed(nums, 0, k - 1)
        self.reversed(nums, k, len(nums) - 1)

    def reversed(self, array: List[int], start: int, end: int) -> None:
        while start < end:
            tmp = array[start]
            array[start] = array[end]
            array[end] = tmp
            start += 1
            end -= 1
