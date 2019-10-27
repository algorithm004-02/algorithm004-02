# 144. Binary Tree Preorder Traversal
# https://leetcode.com/problems/binary-tree-preorder-traversal/
# approach 1: recursive
# time complexity: O(n), sapce complexity: worst O(n), average O(log(n))
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
  def preorderTraversal(self, root: TreeNode) -> List[int]:
    if not root: return []
    res = []
    self._traversal(root, res)
    return res
  
  def _traversal(self, root, res):
    if not root: return res
    res.append(root.val)
    if root.left:
      self._traversal(root.left, res)
    if root.right:
      self._traversal(root.right, res)

# approach 2: iterating
# time complexity: O(n), space complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
  def preorderTraversal(self, root: TreeNode) -> List[int]:
    res = []; stack = [root,]
    if not root: return []
    else:
      while stack:
        root = stack.pop()
        if root:
          res += root.val,
          if root.right:
            stack += root.right,
          if root.left:
            stack += root.left,
    return res