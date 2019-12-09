# https://leetcode-cn.com/problems/group-anagrams/

from collections import defaultdict

# hash+排序分组法
# time complexity: O(NKlogK) K为字符串最大长度
# space complexity: O(NK)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # result = {key1: [...], key2: [...]}
        result = defaultdict(list)
        for i in strs:
            # 排序的字符串作为key 排序后相同key的value归为一组
            result[''.join(sorted(i))].append(i)
        return result.values()


# hash+数组位置计数分组法
# time complexity: O(NK) K为字符串最大长度
# space complexity: O(NK)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # result = {key1: [...], key2: [...]}
        result = defaultdict(list)
        for s in strs:
            # 计算每个字母距离a的ascii值的距离 填充数组位置
            # 数组相同的则为异位词 放入result进行分组
            items = [0] * 26
            for i in s:
                items[ord(i) - ord('a')] += 1
            result[tuple(items)].append(s)
        return result.values()
