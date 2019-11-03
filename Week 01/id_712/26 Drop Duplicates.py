class solution:
    def remove_duplicates(self,nums):
        next_new=0
        for i in range(len(nums)):
            if i==0 or nums[i]!=nums[i-1]:
                nums[next_new]=nums[i]
                next_new=next_new+1
        return next_new

if __name__=='__main__':
    s1=solution()
    print(s1.remove_duplicates([0,0,1,1,1,2,2,3,3,4]))