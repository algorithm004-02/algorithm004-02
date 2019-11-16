"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def postorder(self, root):
        
        """
        :type root: Node
        :rtype: List[int]
        """
        
        if root is None:
            return []
        
        res = []
        stack = [root]
        
        while stack:
            temp = stack.pop()
            
            res.append(temp.val)
            
            if temp.children:
                for val in temp.children:
                    stack.append(val)
        
        return res[::-1]