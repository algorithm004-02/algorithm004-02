# https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/submissions/

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) >> 1
            # 完全有序
            if nums[left] <= nums[mid] <= nums[right]:
                return nums[left]
            # 前半边旋转 后半边有序
            if nums[left] > nums[mid]:
                right = mid
            # 后半边旋转 前半边有序
            elif nums[mid] > nums[right]:
                left = mid + 1
            # 完全逆序
            else:
                return nums[right]
        return nums[left]
