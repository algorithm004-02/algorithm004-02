class Solution:
    # 使用排序后再比较的方法
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
              return False
        if sorted(s) == sorted(t):
            return True
        else:
            return False

    # 使用Hash表,先把第一个字符串添加到字典中,并且遇到相同字符时计数+1
    # 再讲第二个字符串中的字母与字典进行对比,相同时计数-1
    # 最后再判断字典的数据是否都为0
    def isAnagram2(self, s: str, t: str) -> bool:
        dict = {}
        if len(s) != len(t):
            return False

        for i in s:
            dict[i] = dict.get(i,0) + 1

        for j in t:
            dict[j] = dict.get(j,0) -1

        return all(x==0 for x in dict.values())

