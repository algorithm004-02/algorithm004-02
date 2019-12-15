# https://leetcode-cn.com/problems/valid-anagram/submissions/

# 使用库函数
# time complexity: O(NlogN)
# space complexity: O(1)(一般库函数使用快速排序)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        return sorted(s) == sorted(t)


# 数组计数法
# time complexity: O(N)
# space complexity: O(1)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        # 初始化26个元素为0的数组
        items = [0] * 26
        # 遍历s 每个字母距离a的ascii值的距离 在26以内 此位置计数+1
        # 遍历t 每个字母距离a的ascii值的距离 此位置计数-1
        for idx in range(len(s)):
            items[ord(s[idx]) - ord('a')] += 1
            items[ord(t[idx]) - ord('a')] -= 1
        # 数组元素计数都归为0 即为异位词
        for i in items:
            if i != 0:
                return False
        return True


# 数组计数法
# time complexity: O(n)
# space complexity: O(1)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        # 开辟2个26个元素的数组
        arr1, arr2 = [0] * 26, [0] * 26
        # 遍历s和t 计算每个字母距离a的ascii值距离 索引位置计数+1
        for i in s:
            arr1[ord(i) - ord('a')] += 1
        for j in t:
            arr2[ord(j) - ord('a')] += 1
        # 2个数组相同 则为异位词
        return arr1 == arr2


# hashmap记录次数
# time complexity: O(N)
# space complexity: O(1)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        data = {}
        # 遍历s 每个元素放入hashmap中 计数+1
        # 遍历t 每个元素放入hashmap中 计数-1
        for i in range(len(s)):
            data[s[i]] = data.get(s[i], 0) + 1
            data[t[i]] = data.get(t[i], 0) - 1
        # hashmap每个元素计数为0 则为异位词
        for k, v in data.items():
            if v != 0:
                return False
        return True
