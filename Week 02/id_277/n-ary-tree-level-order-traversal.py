"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root is None:
            return

        result = []
        queue = [(0,root)]

        while queue:
            level,root = queue.pop(0)
            if len(result) == level:
                result.append([root.val])
            else:
                result[level].append(root.val)

            if root.children is not None:
                for i in root.children:
                    queue.append((level+1,i))
        return result


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root is None:
            return

        queue = [root]
        result = []

        while queue:
            child = []
            node = []
            for item in queue:
                child.append(item.val)
                if item.children: node.append(item.children)
            result.append(child)
            queue = node
        return result