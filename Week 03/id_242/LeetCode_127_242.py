#
# @lc app=leetcode id=127 lang=python3
#
# [127] Word Ladder
#

# @lc code=start
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0

        l = len(beginWord)
        allComboDict = {}
        for word in wordList:
            for i in range(l):
                newWord = word[:i] + "*" + word[(i+1):]
                transformations = allComboDict.get(newWord, [])
                transformations.append(word)
                allComboDict[newWord] = transformations
        queue = [(beginWord, 1)]
        visited = { beginWord: True }
        while queue:
            word, level = queue.pop(0)
            for i in range(l):
                newWord = word[:i] + "*" + word[(i+1):]
                for adjacentWord in allComboDict.get(newWord, []):
                    if adjacentWord == endWord:
                        return level + 1
                    if adjacentWord not in visited:
                        visited[adjacentWord] = True
                        queue.append((adjacentWord, level + 1))
        return 0
        
# @lc code=end


