#
# @lc app=leetcode.cn id=33 lang=python3
#
# [33] 搜索旋转排序数组
#

# @lc code=start
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def findPiviot(nums) -> int:
            #[1,3]测试用例有可能不存在piviot点
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] >  nums[mid + 1]:
                    return mid + 1
                if left < mid:
                    left = mid + 1
                if left > mid:
                    right = mid - 1

        def findtarget(nums, left, right, target):
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    return mid
                else:
                    if target > nums[mid]:
                        left = mid + 1
                    else:
                        #target < nums[mid]:
                        right = mid - 1
            return -1
                    

        if not nums:
            return -1
        if len(nums) == 1 and nums[0] != target:
            return -1 
        if len(nums) ==1 and nums[0] == target:
            return 0

        pivot = findPiviot(nums)
        #print(pivot)
        if target == nums[pivot]:
            return pivot
        if target > nums[pivot] and target < nums[-1]:
            return findtarget(nums, pivot, len(nums) - 1, target)
        if target > nums[0] and target < nums[pivot - 1]: 
            return findtarget(nums, 0, pivot - 1, target)
        
        return -1


       
# @lc code=end

