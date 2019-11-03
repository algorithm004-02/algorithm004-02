class Solution(object):
    def canJump(self,nums):
        if nums==[]:
            return False
        end=len(nums)-1
        for i in range(end,-1,-1):
            if nums[i]+i>=end:
                end=i
        return end==0

if __name__=="__main__":
    s1=Solution()
    result=s1.canJump([2,3,1,1,4])
    print(result)