class Solution:
    def rob(self, nums: List[int]) -> int:
        #if not nums:return 0
        if len(nums)==1:return nums[0]  #the point
        
        def tou(lista):
            x,y=0,0
            for i in lista:
                x,y =y,max(x+i,y)
            return y
        
        return max(tou(nums[1:]),tou(nums[:-1]))
