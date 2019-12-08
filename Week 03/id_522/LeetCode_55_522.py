


#这个题解很好，说了四种方法，我先用贪心

class Solution:
    def canJump(self, nums: List[int]) -> bool:


        #贪心
        #如果从左边的一个点，能够跳过我，那么，它一定可以跳到我这个位置，
        #如果我能跳到最后，那么，凡是能跳到我这里的，都是解决方案。

        last=len(nums)-1


        for index in range(last-1,-1 ,-1):
            if index+nums[index] >=last:
                last=index

        return last==0
