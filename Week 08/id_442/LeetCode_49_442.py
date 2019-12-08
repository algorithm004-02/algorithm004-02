# https://leetcode-cn.com/problems/group-anagrams/

from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)
        for s in strs:
            items = [0] * 26
            for i in s:
                items[ord(i) - ord('a')] += 1
            result[tuple(items)].append(s)
        return result.values()
