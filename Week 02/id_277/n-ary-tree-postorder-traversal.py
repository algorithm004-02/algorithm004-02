"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root:
            return

        stack = [root]
        result = []
        while stack:
            root = stack.pop()
            result.append(root.val)
            if root.children:
                for i in root.children:
                    stack.append(i)
        return result[::-1]