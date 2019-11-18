"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root:
            return

        stack = [root]
        result = []
        while stack:
            root = stack.pop()
            if root is not None:
                result.append(root.val)

                if root.children is not None:
                    for i in reversed(root.children):
                        stack.append(i)
        return result