#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
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
        if root == None:
            return res
        def recursion(root, depth):
            if root:
                if depth + 1 > len(res):
                    res.append([])
                res[depth].append(root.val)
                for child in root.children:
                    recursion(child, depth + 1)
            
        recursion(root, 0)
        return res

        
# @lc code=end

