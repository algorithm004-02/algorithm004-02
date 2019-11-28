#
# @lc app=leetcode id=212 lang=python3
#
# [212] Word Search II
#

# @lc code=start
import collections

END_OF_WORD = "#"
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

class Solution:


    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0] or not words:
            return []
        root = collections.defaultdict()
        for word in words:
            node = root
            for c in word:
                node = node.setdefault(c, collections.defaultdict())
            node[END_OF_WORD] = END_OF_WORD
        self.m, self.n = len(board), len(board[0])
        self.result = set()
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self.dfs(board, i, j, "", root)
        return list(self.result)

    def dfs(self, board: List[List[str]], i: int, j: int, cur_word: str, cur_dict: dict):
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]
        if END_OF_WORD in cur_dict:
            self.result.add(cur_word)
        tmp, board[i][j] = board[i][j], "@"
        for k in range(4):
            x, y = i + dx[k], j + dy[k]
            if 0 <= x < self.m and 0 <= y < self.n and board[x][y] != "@" and board[x][y] in cur_dict:
                self.dfs(board, x, y, cur_word, cur_dict)
        board[i][j] = tmp


# @lc code=end

