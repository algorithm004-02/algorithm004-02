#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/10/27
# @Author  : xujun
"""
给定一个二叉树，返回它的中序 遍历。
"""


class TreeNode():
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


# 递归
# class Solution(object):
#     def inorderTraversal(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[int]
#         """
#         res = []
#         self.helper(root, res)
#         return res
#
#     def helper(self, root, res):
#         while root.left is not None:
#             self.helper(root.left, res)
#         res.append(root.val)
#         while root.right is not None:
#             self.helper(root.right, res)


# 基于栈的遍历
# class Solution(object):
#     def inorderTraversal(self, root):
#         res = []
#         stack = []
#         temp = root
#         while temp is not None or stack is not None:
#             while temp is not None:
#                 stack.append(temp)
#                 temp = temp.left
#             temp = stack.pop()
#             res.append(temp.val)
#             temp = temp.right


# 颜色标记法
class Solution(object):
    def inorderTraversal(self, root):
        WHITE, GRAY = 0, 1
        res = []
        stack = [(WHITE, root)]
        while stack:
            color, node = stack.pop()
            if node is None: continue
            if color == WHITE:
                stack.append((WHITE, node.right))
                stack.append((GRAY, node))
                stack.append(WHITE, node.left)
            else:
                res.append(node.val)
        return res
