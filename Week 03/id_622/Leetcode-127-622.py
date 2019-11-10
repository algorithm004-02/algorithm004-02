"""
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-ladder
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
         # 此解法会出现超时问题，因为每次都要比对
         # 且过程有bug，放弃，遇到的问题
         # 修改loop中的list, https://stackoverflow.com/questions/1207406/how-to-remove-items-from-a-list-while-iterating
        if endWord not in wordList: return 0
        cur = [beginWord]
        level = 1
        l = len(beginWord)
        
        while cur:
            for j in cur:
                next_word = []
                for word in wordList:
                    count = 0
                    diff = 0
                    # 判断差1个字母，
                    for n in range(l):
                        if j[n] != word[n]:
                            count += 1
                        if j[n] != endWord[n]:
                            diff += 1
                    if count == 0:
                        wordList.remove(word)
                    elif count == 1:
                        if diff == 1:
                            return level + 1
                        next_word.append(word)
                        wordList.remove(word)
                        
            level += 1
            cur = next_word
        return 0
     
     def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        from collections import deque
        # 去重
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        # BFS模版
        visited = set()
        cur = set()
        cur.add(beginWord)
        # 单词长度
        word_n = len(beginWord)
        res = 1
        # BFS
        while cur:
            next_time = set()
            if endWord in cur:
                return res
            for tmp in cur:
                if tmp in wordList:
                    wordList.remove(tmp)
                for i in range(word_n):
                    for a in range(97, 123):
                        w = tmp[:i] + chr(a) + tmp[i+1:]
                        if w in wordList:
                            next_time.add(w)
            res += 1
            cur = next_time
        return 0

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        wordict = set(wordList)
        s1 = {beginWord}
        s2 = {endWord}
        n = len(beginWord)
        step = 0
        wordict.remove(endWord)
        while s1 and s2:
            step += 1
            if len(s1) > len(s2): s1, s2 = s2, s1
            s = set()
            for word in s1:
                nextword = [word[:i] + chr(j) + word[i + 1:] for j in range(97, 123) for i in range(n)]
                for w in nextword:
                    if w in s2:
                        return step + 1
                    if w not in wordict: continue
                    wordict.remove(w)
                    s.add(w)
            s1 = s
        return 0

    # 国际站
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        from collections import deque
        wordList = set(wordList)
        queue = collections.deque([[beginWord, 1]])
        while queue:
            word, length = queue.popleft() # start word = beginWord, length = 1
            if word == endWord:
                return length
            for i in range(len(word)): #构造beginWord的所有变体
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = word[:i] + c + word[i+1:] # 语法糖，学习使用
                    if next_word in wordList:
                        wordList.remove(next_word)
                        queue.append([next_word, length + 1])
        return 0

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0
        wordList = set(wordList)
        queue = [(beginWord, 1)]
        
        while queue:
            word, level = queue.pop(0)
            if word == endWord:
                return level
            for i in range(len(word)):
                change = 'abcdefghijklmnopqrstuvwxyz'
                for j,v in enumerate(change):
                    new = word[:i] + v + word[i+1:]
                    if new in wordList:
                        queue.append((new, level + 1))
                        wordList.remove(new)
        return 0

 