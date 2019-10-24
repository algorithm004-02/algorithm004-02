# https://leetcode-cn.com/problems/move-zeroes/

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        # 双指针法 j记录不为0的位置 i和j位置不同 交换两个元素
        j = 0
        for i, item in enumerate(nums):
            if item != 0:
                nums[j] = item
                if i != j:
                    nums[i] = 0
                j += 1
