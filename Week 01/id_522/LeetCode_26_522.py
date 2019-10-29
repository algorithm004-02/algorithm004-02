<<<<<<< HEAD
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
				
=======
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
				
>>>>>>> upstream/master
        return k + 1