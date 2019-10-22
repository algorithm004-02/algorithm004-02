class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums: 
            return 0
        j = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[j] = nums[i]
                j += 1
        return j