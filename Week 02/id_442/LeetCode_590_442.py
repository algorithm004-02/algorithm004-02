# https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/submissions/

"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""

# 递归 N叉树后序遍历
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        result = []
        self._postorder(result, root)
        return result

    def _postorder(self, result, root):
        if root:
            for node in root.children:
                self._postorder(result, node)
            result.append(root.val)
