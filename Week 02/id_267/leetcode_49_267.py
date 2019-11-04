###############排序数组分类#############################
import collections
class Solution:
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return ans.values()


###############按计数分类#####################
# class Solution:
#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
#         res = []
#         dic = {}
#         for s in strs:
#             keys = "".join(sorted(s))
#             if keys not in dic:
#                 dic[keys] = [s]
#             else:
#                 dic[keys].append(s)
#         return list(dic.values())

################光头哥#######################

# class Solution:
#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
#         return [sorted(g) for _, g in itertools.groupby(sorted(strs, key=sorted), sorted)]


################test cases##############
strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
obj = Solution()
print(obj.groupAnagrams(strs))