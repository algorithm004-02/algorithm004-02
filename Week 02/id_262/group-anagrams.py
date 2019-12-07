from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        obj = {}
        for s in strs:
            obj[tuple(sorted(s))] = obj.get(tuple(sorted(s)), []) + [s]
        return list(obj.values())
