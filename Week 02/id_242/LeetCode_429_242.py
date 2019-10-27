#
# @lc app=leetcode id=429 lang=python3
#
# [429] N-ary Tree Level Order Traversal
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
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res = []
        if root:
            self.helper(root, 0, res)
        return res

    def helper(self, node: 'Node', depth: int, res: List[List[int]]): 
        if node:
            if depth + 1 > len(res):
                res.append([])
            res[depth].append(node.val)
            for child in node.children:
                if child:
                    self.helper(child, depth+1, res)

        
# @lc code=end

