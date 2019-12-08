# https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1

        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right + 1) >> 1
            # 后半部分有序
            if nums[mid] < nums[right]:
                if nums[mid] <= target <= nums[right]:
                    left = mid
                else:
                    right = mid - 1
            else:
                # 前半部分有序
                if nums[left] <= target <= nums[mid - 1]:
                    right = mid - 1
                else:
                    left = mid
        return left if nums[left] == target else -1
