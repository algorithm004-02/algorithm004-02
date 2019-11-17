class Solution:
    def maxProduct(self,nums):
        max_,min_,res=nums[0],nums[0],nums[0]
        for i in range(1,len(nums)):
            max_tmp=max_
            max_=max(max_tmp*nums[i],nums[i],min_*nums[i])
            min_=min(max_tmp*nums[i],nums[i],min_*nums[i])
            if max_>res:
                res=max_
        return res