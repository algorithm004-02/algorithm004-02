#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#

# @lc code=start
from collections import defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if not beginWord or not endWord or not wordList:
            return 0
        cobom_word = defaultdict(list)
        for word in wordList:
            for i in range(0, len(beginWord)):
                cobom_word[word[:i] + '*' + word[i + 1 :]].append(word)
        queue = []
        queue.append((beginWord, 1))
        
        visited = []
        visited.append(beginWord)
        while queue:
            currWord, level = queue.pop(0)
            for i in range(0, len(beginWord)):
                interWord = currWord[:i] + '*' +currWord[i+1:]
                for word in cobom_word[interWord]:
                    if endWord == word:
                        return level + 1
                    if word not in visited:
                        queue.append((word, level + 1))
                        visited.append(word)

        return 0
                


     
# @lc code=end

