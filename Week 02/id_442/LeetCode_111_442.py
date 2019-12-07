# https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left_depth = self.minDepth(root.left)
        right_depth = self.minDepth(root.right)
        if not root.left:
            return right_depth + 1
        if not root.right:
            return left_depth + 1
        return min(left_depth, right_depth) + 1
