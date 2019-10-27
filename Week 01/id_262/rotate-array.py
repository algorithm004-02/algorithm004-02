from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return None
        for i in range(k):
            nums.insert(0, nums[-1])
            nums.pop(-1)