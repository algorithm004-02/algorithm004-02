# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.lowest(root, p.val, q.val)

    def lowest(self, root, pv, qv):

        if root.val == pv or root.val == qv:
            return root

        left = self.lowest(root.left, pv, qv)
        right = self.lowest(root.right, pv, qv)

        if left is not None and right is not None:
            return root
        return None
