# 第5次

class Solution:
    def rob(self, nums: List[int]) -> int:
        # f=far ,n =near
        f, n = 0, 0
        for i in nums:
            n, f = max(f + i, n), n
        return n


'''
第4次
class Solution:
    def rob(self, nums: List[int]) -> int:
        far,near =0,0
        for i in nums:
            near,far = max(far+i ,near),near
        return near


'''

# 第3次
'''
class Solution(object):
    def rob(self, nums):
        if not nums:return 0
        size =len(nums)
        dp=nums[:]
        if size ==0:
            return 0
        elif size==1:
            return nums[0]
        elif size==2:
            
            return max(nums[0],nums[1])
        dp[1]= max(nums[0],nums[1])
        for k in range(2,size):
            dp[k]=max(dp[k-1],dp[k-2]+nums[k])
            
        return dp[k]
'''

# 第二次 斐波那契数列
'''
class Solution(object):
    def rob(self, nums):
        x=y=0
        for i in nums:
            x,y = y , max(x+i,y)
        return y

'''
# 第1
'''
class Solution(object):
    def rob(self, nums):

        if not nums :return 0
        kk=len(nums)
        
        if kk==1 :return nums[0]
        if kk==2 :return max (nums[0],nums[1])

        dp=[0 for _ in range(kk)]
        dp[0]=nums[0]
        dp[1]=max(nums[1],nums[0])
        
        for i in range (2,kk):
            dp[i]= max(dp[i-1],dp[i-2]+nums[i])

        return max(dp[kk-1],dp[kk-2])
'''
