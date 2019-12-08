"""
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2], 

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    """
    方法一、从头往后遍历，有重复的则出数组, 因为nums.pop(i)的复杂度为O(n)，所以总体
    复杂度为O(n^2)，执行效果不好
    """
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        start = 1
        while start != len(nums):
            for i in range(start, len(nums)):
                if nums[i] == nums[i-1]:
                    nums.pop(i)
                    break
                else:
                    start += 1
        return start

    """
    双指针
    """
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        start = 0
        for i in range(1, len(nums)):
            if nums[i] != nums[start]:
                nums[start+1] = nums[i]
                start += 1
        return start+1