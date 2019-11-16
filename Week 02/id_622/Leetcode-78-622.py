"""
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # 视频课程解法
        """
        Step1 : init result include []
        Step2 : loop the result
        Step3 : insert the num in the loop result and rebuild the result
        """
        result = [[]]
        for num in nums:
            new_set = []
            for subset in result:
                new_subset = subset + [num]
                new_set.append(new_subset)
            result.extend(new_set)
        return result

    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Leetcode 经典解法， 迭代
        res = [[]]
        for i in nums:
            res = res + [[i] + num for num in res]
        return res

    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Leetcode 递归
        res = []
        n = len(nums)
        
        def helper(i, tmp):
            res.append(tmp)
            for j in range(i, n):
                helper(j + 1,tmp + [nums[j]] )
        helper(0, [])
        return res
                
                