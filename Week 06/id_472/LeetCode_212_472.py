#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/12/1
# @Author  : xujun
import collections

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
END_OF_WORD = "#"


class Solution:
    def findWords(self, board, words):
        if not board or not board[0]: return []
        if not words: return []
        self.result = set()
        # 构建trie
        root = collections.defaultdict()
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, collections.defaultdict())
            node[END_OF_WORD] = END_OF_WORD
        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, "", root)
        return list(self.result)

    def _dfs(self, board, i, j, cur_word, cur_dict):
        # 当前层逻辑
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]
        if END_OF_WORD in cur_dict:
            self.result.add(cur_word)
        # drill down
        tmp, board[i][j] = board[i][j], '@'
        for k in range(4):
            x, y = i + dx[k], j + dy[k]
            if 0 <= x < self.m and 0 <= y < self.n \
                    and board[x][y] != '@' and board[x][y] in cur_dict:
                self._dfs(board, x, y, cur_word, cur_dict)
        # 回复
        board[i][j] = tmp
