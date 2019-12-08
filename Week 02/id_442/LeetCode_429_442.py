# https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/submissions/

"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""

# 递归 层序遍历
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        result = []
        self._level_order(result, 0, root)
        return result

    def _level_order(self, result, depth, root):
        if not root:
            return
        if depth + 1 > len(result):
            result.append([])
        result[depth].append(root.val)
        for i in root.children:
            self._level_order(result, depth+1, i)
