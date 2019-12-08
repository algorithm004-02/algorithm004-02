from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        queue = [root]
        result = []

        while queue:
            childs = []
            node = []
            for item in queue:
                childs.append(item.val)
                if item.left:
                    node.append(item.left)
                if item.right:
                    node.append(item.right)
            result.append(childs)
            queue = node
        return result

