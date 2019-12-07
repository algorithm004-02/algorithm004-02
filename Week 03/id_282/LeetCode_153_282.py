class Solution:
    """
    二分法, 二分法就是找与mid判断条件,这里我们选用right
    当nums[mid] > nums[right]说明在mid左半边的递增区域, 说明最小元素在> mid区域
    当nums[mid] <= nums[right说明在mid右半边的递增区域, 说明最小元素在<= mid区域
    小技巧:
        当while left < right是循环外输出
        当while left <= right是循环里输出
    """
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1 
        while left < right:
            mid = left + (right - left) // 2
            if nums[right] < nums[mid]:
                left = mid + 1
            else:
                right = mid 
        return nums[left]