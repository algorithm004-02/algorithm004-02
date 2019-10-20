class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        arraylist = []
        count = 0
        for i in range(len(nums) - k, len(nums)):
            arraylist.append(nums[i])
        for i in range(0 , len(nums) - k ):
            arraylist.append(nums[i])
        for i in range(0, len(nums)):
            nums[i] = arraylist[i]