#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/23 下午3:26
@Author : Catherinexxx
@Site : 
@File : 144.binary-tree-preorder-transversal.py
@Software: PyCharm
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 1、迭代 stack 根左右
## 超时
# class Solution:
#     def preorderTraversal(self, root: TreeNode) -> List[int]:
#         res, stack = [], []
#         p = root
#         while True:
#             while p.left or p.right:
#                 res.append(p.val)
#                 if p.right:
#                     stack.append(p.right)
#                 if p.left:
#                     stack.append(p.left)
#             p = stack.pop()
#         return res

# class Solution(object):
#     def preorderTraversal(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[int]
#         """
#         res = []
#         p = root
#         stack = []
#         while p or stack:
#             while p:
#                 res.append(p.val)
#                 stack.append(p)
#                 p = p.left
#             p = stack.pop().right
#         return res


# 2、递归
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []

        def preorder(node):
            if not node:
                return
            res.append(node.val)
            preorder(node.left)
            preorder(node.right)

        preorder(root)
        return res