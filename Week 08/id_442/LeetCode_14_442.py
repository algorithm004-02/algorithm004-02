# https://leetcode-cn.com/problems/longest-common-prefix/

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""

        for i, s in enumerate(strs[0]):
            for j in range(1, len(strs)):
                if i == len(strs[j]) or strs[j][i] != s:
                    return strs[0][:i]
        return strs[0]
