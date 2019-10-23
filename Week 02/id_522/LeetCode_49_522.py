class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        import collections
        ans = collections.defaultdict(list)
        for s in strs:
            count = [0] * (26+97)  # ord("a")==97
            for c in s:
                count[ord(c)] += 1
            ans[tuple(count)].append(s)
        return ans.values()



'''
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        str_map = {}
        res = []
        for s in strs:
            temp = ''.join(sorted(s))    #use sorted ,i donot like it
            if temp not in str_map:
                str_map[temp] = len(res)   #the good idea 
                res.append([s])
            else:
                res[str_map[temp]].append(s)
        return res

'''
