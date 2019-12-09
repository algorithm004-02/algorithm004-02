# https://leetcode-cn.com/problems/word-search-ii/

from typing import Mapping, Set

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
end = '#'

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0] or not words:
            return []
        # 构建trie树
        trie = self.build_trie(words)
        # 遍历dfs
        result = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] in trie:
                    self.dfs(i, j, board, '', trie, result)
        return list(result)

    def build_trie(self, words: List[str]) -> Mapping:
        trie = {}
        for word in words:
            node = trie
            for w in word:
                node = node.setdefault(w, {})
            node[end] = end
        return trie

    def dfs(self, i: int, j: int, board: List[List[str]], current: str, node: Mapping, result: Set[str]):
        # 在trie树中的单词累加到result
        current += board[i][j]
        node = node[board[i][j]]
        if end in node:
            result.add(current)
        # 遍历四联通方向继续查找
        tmp, board[i][j] = board[i][j], '@'
        for k in range(4):
            x, y = i + dx[k], j + dy[k]
            if 0 <= x < len(board) and 0 <= y < len(board[0]) and board[x][y] != '@' and board[x][y] in node:
                self.dfs(x, y, board, current, node, result)
        board[i][j] = tmp


# 更简洁的代码实现
from typing import Mapping, Set

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        # 构建trie树
        trie = {}
        for word in words:
            node = trie
            for w in word:
                node = node.setdefault(w, {})
            node['#'] = True

        result, w, h = set(), len(board), len(board[0])

        # dfs
        def dfs(i: int, j: int, node: Mapping, prev: str, visited: Set):
            if '#' in node:
                result.add(prev)
            for (di, dj) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                x, y = i + di, j + dj
                if 0 <= x < w and 0 <= y < h and board[x][y] in node and (x, y) not in visited:
                    dfs(x, y, node[board[x][y]], prev + board[x][y], visited | {(x, y)})

        # 遍历网格
        for i in range(w):
            for j in range(h):
                if board[i][j] in trie:
                    dfs(i, j, trie[board[i][j]], board[i][j], {(i, j)})
        return list(result)

