# rotate-array
# 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
# 1、暴力（循环）,超时
        # for i in range(k):
        #     tmp = nums[-1]
        #     for j in range(len(nums)-1, 0, -1):
        #         nums[j] = nums[j-1]
        #     nums[0] = tmp
# 2、slice（切片），这个方法想到了，在实现的时候切片界限考虑不到位，对k%=n的理解不够
# A little important thing to be cautious:
# nums[:] = nums[n-k:] + nums[:n-k] 
# can't be written as:
# nums = nums[n-k:] + nums[:n-k]

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        nums[:] = nums[n-k:] + nums[:n-k]