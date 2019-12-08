class Solution:
    def groupAnagrams(self, strs):
        d = {}
        for w in sorted(strs):
            key = tuple(sorted(w))
            d[key] = d.get(key, []) + [w]
        return d.values()

if __name__=="__main__":
    s1=Solution()
    s1.groupAnagrams()
