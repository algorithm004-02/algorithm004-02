<<<<<<< HEAD
class Solution:
    def twoSum(self,nums, target):
        hashmap={}
        for i,num in enumerate(nums):
            if target-num in hashmap.keys():
                return [i,hashmap.get(target - num)]
=======
class Solution:
    def twoSum(self,nums, target):
        hashmap={} 
        for i,num in enumerate(nums):
            if target-num in hashmap.keys():
                return [i,hashmap.get(target - num)]
>>>>>>> upstream/master
            hashmap[num] = i