#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
import collections
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict = collections.defaultdict(list)
       
        for s in strs:
            nums = [0] * 26
            for c in s:
               nums[ord(c) - ord('a')] += 1
            dict[tuple(nums)].append(s)
        return dict.values()
# @lc code=end

