# class Solution:
#     def twoSum(self, nums, target: int):
#         for i in range(len(nums)):
#             if(target-nums[i] in nums and i != nums.index(target-nums[i])):
#                     return [i,nums.index(target-nums[i])]


######################################
# O(n) 执行用时 : 72 ms
class Solution(object):
    def twoSum(self, nums, target):
        if len(nums) <= 1:
            return False
        buff_dict = {}
        for i in range(len(nums)):
            if nums[i] in buff_dict:
                return [buff_dict[nums[i]], i]
            else:
                buff_dict[target - nums[i]] = i

################test cases##############
nums = [2, 7, 11, 15]
target = 9
obj = Solution()
print(obj.twoSum(nums, target))