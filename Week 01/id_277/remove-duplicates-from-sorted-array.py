class Solution:
    """
    此题使用了双指针的解法;
    定义前指针和后指针,每次循环后指针的位置都向后移动一位;
    当发现后指针与前指针的数值不同时,再将后指针的数据复制到前指针的后一位,同时将前指针后移一位;
    """
    def removeDuplicates(self, nums: List[int]) -> int:
        before = 0
        after = 1

        while(after < len(nums)):
            if nums[before] != nums[after]:
                nums[before + 1] = nums[after]
                before +=1
            after +=1

        return before+1