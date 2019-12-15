from collections import deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        def construct_dict(wordList):
            d = {}
            for word in wordList:
                for i in range(len(word)):
                    s = word[:i] + "*" + word[i + 1:]
                    d[s] = d.get(s, []) + [word]
            return d

        def bfs_words(begin, end, dict_words):
            queue, visited = deque([(begin, 1)]), set()
            while queue:
                word, steps = queue.popleft()
                if word not in visited:
                    visited.add(word)
                    if word == end:
                        return steps

                    for i in range(len(word)):
                        s = word[:i] + "*" + word[i + 1:]
                        neigh_words = dict_words.get(s, [])
                        for neigh in neigh_words:
                            if neigh not in visited:
                                queue.append((neigh, steps + 1))
            return 0

        if endWord not in wordList or not wordList or not beginWord or not endWord:
            return 0

        d = construct_dict(wordList)
        return bfs_words(beginWord, endWord, d)