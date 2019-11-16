class solution(object):
    def move_zeroes(self,nums):
        i=0
        for num in nums:
            if num!=0:
                nums[i]=num
                i=i+1
        nums[i:]=[0]*(len(nums)-i)
        return nums

if __name__=="__main__":
    s1=solution()
    print(s1.move_zeroes([2,3,0,1,0,9,0,4]))