#
# @lc app=leetcode id=589 lang=python3
#
# [589] N-ary Tree Preorder Traversal
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        self.helper(root, res)
        return res

    def helper(self, root: 'Node', res: List[int]):
        if root:
            res.append(root.val)
            for child in root.children:
                self.helper(child, res)

    # def preorder(self, root: 'Node') -> List[int]:
    #     res = []
    #     stack = [(root, False)]
    #     while root and stack:
    #         cur, visited = stack.pop()
    #         if cur and visited:
    #             res.append(cur.val)
    #         else:
    #             if cur:
    #                 l = len(cur.children)
    #                 for i in range(l):
    #                     stack.append((cur.children[l-i-1], False))
    #                 stack.append((cur, True))
    #     return res
        
# @lc code=end

