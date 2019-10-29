class Solution:
    # 构建一个嵌套Hash表,将排序后的字符串作为Key,原字符串作为Value存放到Hash表
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict = collections.defaultdict(list)

        for word in strs:
            dict[''.join(sorted(word))].append(word)
        return dict.values()