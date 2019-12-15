class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 利用映射先登记后查询
        hash = {}
        for i in range(len(nums)):
            hash[target-nums[i]] = i
        
        for i in range(len(nums)):
            if nums[i] in hash and hash[nums[i]] != i:
                return [i, hash[nums[i]]]
