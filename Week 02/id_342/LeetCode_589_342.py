"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
# 递归
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        self.res = []
        def do(root):
            for i in root.children:
                if i:
                    self.res.append(i.val)
                    do(i)
                    
        
        self.res.append(root.val)
        do(root)
        
        return self.res
