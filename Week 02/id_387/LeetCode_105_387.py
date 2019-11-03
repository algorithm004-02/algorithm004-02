# 105. Construct Binary Tree from Preorder and Inorder Traversal
# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# approach 1: recursion
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
  def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
    map = {num: idx for idx, num in enumerate(inorder)}
    return self.build(preorder, inorder, 0, len(inorder) - 1, map)
  
  def build(self,preorder, inorder, start, end, map):
    if start > end: return
    root = TreeNode(preorder.pop(0))
    idx = map[root.val]
    
    root.left = self.build(preorder, inorder, start, idx - 1, map)
    root.right = self.build(preorder, inorder, idx + 1, end, map)
    return root

