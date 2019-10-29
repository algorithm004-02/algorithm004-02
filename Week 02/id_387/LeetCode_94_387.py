# 94. Binary Tree Inorder Traversal
# https://leetcode.com/problems/binary-tree-inorder-traversal/
# Approach 1: recursive
# time complexity: O(n), sapce complexity: worst O(n), average O(log(n))
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
  def inorderTraversal(self, root: TreeNode) -> List[int]:
    if not root: return []
    res = []
    self._traversal(root, res)
    return res
    
  def _traversal(self, root, res):
    if not root: return res
    if root.left:
      self._traversal(root.left, res)
      
    res.append(root.val)
    
    if root.right:
      self._traversal(root.right, res)

# Approach 2: iterating
# time complexity: O(n), sapce complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
  def inorderTraversal(self, root: TreeNode) -> List[int]:
    if not root: return []
    res = []; stack = []; curr = root
    while curr or stack:
      if curr:
        stack.append(curr)
        curr = curr.left
      else:
        curr = stack.pop()
        res.append(curr.val)
        curr = curr.right
    return res