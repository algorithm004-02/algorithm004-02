"""
1 、暴力循环
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(0 , len(nums)-1):
            for j in range(i+1 , len(nums)):
                if nums[i] + nums[j] == target:
                    return [i,j]
"""
2、字典  两遍循环，2+2 3+3 相同数字出现两遍就会出错

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sumdict = {};
        for i in range(0 , len(nums)):
            sumdict = [nums[i] , i]
            print(sumdict)
        for j in range(0 ,  len(nums)):
            if (target - nums[j]) in sumdict:
               print( j )
               print(target - nums[j])
               print(sumdict[target - nums[j]]
                     
执行时报错 key为数值时会与序号相混
不允许同一键出现两次，3 3 如何处理
"""