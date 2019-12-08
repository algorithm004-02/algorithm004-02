#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/18 下午2:20
@Author : Catherinexxx
@Site : 
@File : 212. Word Search II.py
@Software: PyCharm
"""


# 1、words遍历————》board找 O(N*M*M*4^k)
# 2、trie
# a all words ————》 trie 构建prefix
# b board DFS
# class Solution:
#     def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
#         trie = {}  # 构造字典树
#         for word in words:
#             node = trie
#             for char in word:
#                 node = node.setdefault(char, {})
#             node['#'] = True

#         def search(i, j, node, pre, visited):  # (i,j)当前坐标，node当前trie树结点，pre前面的字符串，visited已访问坐标
#             if '#' in node:  # 已有字典树结束
#                 res.add(pre)  # 添加答案
#             for (di, dj) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
#                 _i, _j = i+di, j+dj
#                 if -1 < _i < h and -1 < _j < w and board[_i][_j] in node and (_i, _j) not in visited:  # 可继续搜索
#                     search(_i, _j, node[board[_i][_j]], pre+board[_i][_j], visited | {(_i, _j)})  # dfs搜索

#         res, h, w = set(), len(board), len(board[0])
#         for i in range(h):
#             for j in range(w):
#                 if board[i][j] in trie:  # 可继续搜索
#                     search(i, j, trie[board[i][j]], board[i][j], {(i, j)})  # dfs搜索
#         return list(res)


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        # 构建trie
        trie = {}
        for word in words:
            t = trie
            for w in word:
                t = t.setdefault(w, {})
            t["end"] = 1
        # print(trie)

        res = []
        row = len(board)
        col = len(board[0])

        def dfs(i, j, trie, s):
            # print(i, j, trie, s)
            c = board[i][j]
            if c not in trie: return
            trie = trie[c]
            if "end" in trie and trie["end"] == 1:
                res.append(s + c)
                trie["end"] = 0  # 防止重复数组加入
            board[i][j] = "#"  # 防止字母重复用
            for x, y in [[-1, 0], [1, 0], [0, 1], [0, -1]]:
                tmp_i = x + i
                tmp_j = y + j
                if 0 <= tmp_i < row and 0 <= tmp_j < col and board[tmp_i][tmp_j] != "#":
                    dfs(tmp_i, tmp_j, trie, s + c)
            board[i][j] = c  # 回溯 先前改了board

        for i in range(row):
            for j in range(col):
                dfs(i, j, trie, "")
        return res