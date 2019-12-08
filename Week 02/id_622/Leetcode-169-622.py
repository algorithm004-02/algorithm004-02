"""
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 哈希表暴力法，需要遍历所有元素
        dict = {}
        for i in nums:
            if i not in dict:
               dict[i] = 1
            else:
               dict[i] += 1
        for (k,v) in dict.items():
            if v > len(nums)/2:
                return k

    def majorityElement(self, nums: List[int]) -> int:
        # 哈希表遇到大于n/2的，退出，需要判断边界为1个数组的情况
        if len(nums) == 1: return nums[0]
        dict = {}
        for i in nums:
            if i not in dict:
               dict[i] = 1
            else:
               dict[i] += 1
               if dict.get(i) > len(nums)/2:
                    return i

    def majorityElement(self, nums: List[int]) -> int:
        """
        排序以后，从头到尾遍历一次，遇到最大值大于n/2的，直接返回
        """
        if len(nums) == 1: return nums[0]
        max = 1
        stack = []
        n = sorted(nums)
        for i in n:
            if not stack:
                stack.append(i)
            else:
                if i == stack[-1]:
                    max += 1
                    if max > len(nums)/2:
                        return stack[-1]
                else:
                    stack.append(i)