def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        b = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[b], nums[i] = nums[i], nums[b]
                b += 1