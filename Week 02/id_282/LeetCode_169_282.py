class Solution:
    '''
    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在众数。
    分治
    '''
    def majorityElement(self, nums: List[int]) -> int:
        if not nums: return 
        if len(nums) == 1: return nums[0]
        left = self.majorityElement(nums[:len(nums)//2])
        right = self.majorityElement(nums[len(nums)//2:])
        if left == right:
            return left
        return left if nums.count(left) > len(nums)// 2 else right