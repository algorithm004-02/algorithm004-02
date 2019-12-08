class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        ans = collections.defaultdict(list)
        
        for str in strs:
            count = [0] * 26
            
            for l in str:
                count[ord(l) - ord('a')] += 1
            
            ans[tuple(count)].append(str)
        return ans.values()