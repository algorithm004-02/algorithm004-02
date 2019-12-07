# https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/
"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""

# 递归 N叉树前序遍历
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        self._preorder(result, root)
        return result

    def _preorder(self, result, root):
        if root:
            result.append(root.val)
            for node in root.children:
                self._preorder(result, node)


# 非递归 使用栈实现N叉树前序遍历
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        result, stack = [], [root]
        while len(stack) != 0:
            node = stack.pop()
            if node:
                result.append(node.val)
                items = node.children
                for i in range(len(items)-1, -1, -1):
                    stack.append(items[i])
        return result
