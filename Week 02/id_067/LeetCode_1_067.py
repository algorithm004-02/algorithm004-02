class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return False
        dict = {}
        for i in range(0 , len(nums)):
            dict[nums[i]] = i
        for i in range(0, len(nums)):
            if (target - nums[i] in dict) and i != dict[target - nums[i]]:
                return [ i , dict[target - nums[i]]]