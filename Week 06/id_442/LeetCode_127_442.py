# https://leetcode-cn.com/problems/word-ladder/

# BFS
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        queue, word_set = deque([(beginWord, 1)]), set(wordList)
        while queue:
            current, step = queue.popleft()
            if current == endWord:
                return step
            for i in range(len(current)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    if current[i] == c:
                        continue
                    word = current[:i] + c + current[i+1:]
                    if word in word_set:
                        word_set.remove(word)
                        queue.append((word, step + 1))
        return 0



# 双向BFS
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        front, back, step = {beginWord}, {endWord}, 1
        while front and back:
            step += 1
            next_front = set()
            for word in front:
                for i in range(len(beginWord)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if word[i] == c:
                            continue
                        new_word = word[:i] + c + word[i+1:]
                        if new_word in back:
                            return step
                        if new_word in wordList:
                            next_front.add(new_word)
                            wordList.remove(new_word)
            front = next_front

            if len(back) < len(front):
                fron, back = back, front
        return 0
