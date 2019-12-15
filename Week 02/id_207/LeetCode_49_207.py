<<<<<<< HEAD
=======

>>>>>>> 8fe26f6a4e46679f8d1b1ee01edf8197505ca1be
# [49] 字母异位词分组
#  思路：
from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = defaultdict(list)
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            ans[tuple(count)].append(s)
        
<<<<<<< HEAD
        return ans.values()
=======
        return ans.values()
>>>>>>> 8fe26f6a4e46679f8d1b1ee01edf8197505ca1be
