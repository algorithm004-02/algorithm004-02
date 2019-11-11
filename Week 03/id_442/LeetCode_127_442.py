# https://leetcode-cn.com/problems/word-ladder/submissions/

from collections import deque

# BFS
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        queue, word_set = deque([(beginWord, 0)]), set(wordList)
        while queue:
            current, step = queue.popleft()
            if current == endWord:
                return step + 1
            for i in range(len(current)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    word = current[:i] + c + current[i+1:]
                    if word in word_set:
                        word_set.remove(word)
                        queue.append((word, step + 1))
        return 0
