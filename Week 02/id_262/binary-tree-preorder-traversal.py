from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        l = []
        l.append(root.val)
        l += self.inorderTraversal(root.left)
        l += self.inorderTraversal(root.right)
        return l
