#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/20 上午11:22
@Author : Catherinexxx
@Site : 
@File : 37. Sudoku Solver.py
@Software: PyCharm
"""

# 超时
# class Solution:
#     def solveSudoku(self, board: List[List[str]]) -> None:
#         """
#         Do not return anything, modify board in-place instead.
#         """
#         for i in range(9):
#             for j in range(9):
#                 if board[i][j] == ".":
#                     for n in range(1, 10):
#                         board[i][j] = n
#                         if self.isValidSudoku(board):
#                             self.solveSudoku(board)
#                         else:
#                             board[i][j] = '.'
#         return board

#     def isValidSudoku(self, board):
#         """
#         :type board: List[List[str]]
#         :rtype: bool
#         """
#         # init data
#         rows = [{} for i in range(9)]
#         columns = [{} for i in range(9)]
#         boxes = [{} for i in range(9)]

#         # validate a board
#         for i in range(9):
#             for j in range(9):
#                 num = board[i][j]
#                 if num != '.':
#                     num = int(num)
#                     box_index = (i // 3) * 3 + j // 3

#                     # keep the current cell value
#                     rows[i][num] = rows[i].get(num, 0) + 1      # get(k,default) k在则取k的val，不在则0
#                     columns[j][num] = columns[j].get(num, 0) + 1
#                     boxes[box_index][num] = boxes[box_index].get(num, 0) + 1

#                     # check if this value has been already seen before
#                     if rows[i][num] > 1 or columns[j][num] > 1 or boxes[box_index][num] > 1:
#                         return False
#         return True

# 回溯
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:

        # 预处理得到空格以及行列块可用数字
        row = [set(range(1, 10)) for _ in range(9)]  # 行剩余可用数字
        col = [set(range(1, 10)) for _ in range(9)]  # 列剩余可用数字
        block = [set(range(1, 10)) for _ in range(9)]  # 块剩余可用数字

        empty = []  # 收集需填数位置
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':  # 更新可用数字
                    val = int(board[i][j])
                    row[i].remove(val)
                    col[j].remove(val)
                    block[(i // 3)*3 + j // 3].remove(val)
                else:
                    empty.append((i, j))

        def backtrack(iter=0):
            if iter == len(empty):  # 处理完empty代表找到了答案
                return True
            i, j = empty[iter]
            b = (i // 3)*3 + j // 3
            for val in row[i] & col[j] & block[b]:
                row[i].remove(val)
                col[j].remove(val)
                block[b].remove(val)
                board[i][j] = str(val)
                if backtrack(iter+1):
                    return True
                row[i].add(val)  # 回溯
                col[j].add(val)
                block[b].add(val)
            return False
        backtrack()