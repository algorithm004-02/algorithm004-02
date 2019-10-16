class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """        
        if not nums: 
            return 0
        k = 0
        for i in nums[1:]:
            if nums[k] != i:
                k = k + 1 
                nums[k] = i	
				
        return k + 1