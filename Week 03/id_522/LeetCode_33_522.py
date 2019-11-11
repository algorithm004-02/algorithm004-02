class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left , right= 0 , len(nums)-1
        while left <= right:  #这里的 = 很重要

            mid =left+right>>1
            if nums[mid] == target :
                return mid
            #假设左边是升序的
            if nums[left]<=nums[mid]:
                if  nums[left] <= target <nums[mid]:  #这里的= 不可能 target <=nums[mid]
                    right=mid-1
                else:
                    left=mid+1
            else: #此时右边是升序的
                if nums[mid] < target <=nums[right]:
                    left=mid+1
                else:
                    right=mid-1
        return -1


    #一开始没有写出来，纸上画了分支，也没有写对。
