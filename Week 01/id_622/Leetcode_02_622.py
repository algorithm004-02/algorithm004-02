"""
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    """
    思考：
        方法一、 暴力法，两遍循环，时间复杂度O(n^2)
        实际过程中遇到问题：
            代码在Leetcode中测试用例无法通过，显示超时，不知道是否是算法问题
            考虑修改循环算法
        方法二、 哈希表查表法，复杂度O(n)
        实际过程中遇到问题：
            for k,v in enumerate(nums) 替代以前常用的for i in range(len(nums))
    """
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for key,value in enumerate(nums):
            if target - value in hashmap:
                return [hashmap.get(target - value), key]
            hashmap[value] = key