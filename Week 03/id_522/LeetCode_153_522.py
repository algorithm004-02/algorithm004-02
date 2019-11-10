class Solution:
    def findMin(self, nums: List[int]) -> int:

        if not nums :return []

        if len(nums)<6:return min(nums)
        if nums[-1]<nums[-2]:return nums[-1]

        left,right =0,len(nums)-1

        while left <right:

            mid=left+right>>1

            if nums[mid-1]>nums[mid]<nums[mid+1]:
                return nums[mid]

            if nums[right]<nums[left]<=nums[mid] :
                left=mid+1
            else:
                right=mid

'''
这道题，测试用例，帮我完善了很多，也就是我们写的程序，边界条件，根本考虑不好。
上面是第一遍，拿出模板，硬写的。
还没有看题解。

'''
