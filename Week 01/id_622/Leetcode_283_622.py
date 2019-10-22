"""
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
        定义两个指针，i, j，同时从0开始遍历，j记录非0元素的位置
        用i遍历数组，如果 nums[i] ！= 0，则nums[j] = nums[i]
        如果此时的i, j位于同一个位置，nums[i] = 0,后续i+1, j+1
        
        注意：两个指针的遍历操作法，熟练度
        for 循环调用本身，另外一个指针用于做存储判断
        """
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                # 交换位置以后，当前的元素需要设置为0，如果i, j同时指向当前位置，且不为0，则不能操作
                if i != j:
                    nums[i] = 0
                j += 1
        return nums

    def moveZeroes_2(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        """
        暴力法，当找到元素为0时，去查找下一个非零元素，进行交换
        """
        n = len(nums)
        for i in range(n):
            j = i
            while j < n:
                if nums[i] == 0:
                    if nums[j] != 0:
                        nums[i], nums[j] = nums[j], 0
                j += 1
        return nums

                    