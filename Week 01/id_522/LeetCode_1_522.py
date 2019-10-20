class Solution:
    def twoSum(self,nums, target):
        hashmap={}
        for i,num in enumerate(nums):
            if target-num in hashmap.keys():
                return [i,hashmap.get(target - num)]
            hashmap[num] = i