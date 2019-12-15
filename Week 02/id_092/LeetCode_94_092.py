#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/23 下午2:48
@Author : Catherinexxx
@Site : 
@File : 94.binary-tree-inorder-traversal.py
@Software: PyCharm
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 1、迭代 stack
# class Solution:
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         stack = []
#         # 用p当做指针
#         p = root
#         while True:
#             # 把左子树压入栈中
#             while p:
#                 stack.append(p)
#                 p = p.left
#             # 输出 栈顶元素
#             p = stack.pop()
#             res.append(p.val)
#             # 看右子树
#             p = p.right
#         return res

# # 2、递归
class Solution:
     def inorderTraversal(self, root: TreeNode) -> List[int]:
            res = []
            def inorder(node):
                if not node:
                    return
                inorder(node.left)
                res.append(node.val)
                inorder(node.right)
            inorder(root)
            return res