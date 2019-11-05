#
# @lc app=leetcode.cn id=236 lang=python3
#
# [236] 二叉树的最近公共祖先
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def count_tree(root, p, q):
            if root == None:
                return False
            left = count_tree(root.left, p, q)
            right = count_tree(root.right, p, q)
            mid = 0
            if root == p or root == q:
                mid = 1
            if mid + left + right >= 2:
                self.ans = root
            #print(root.val)
            #print(mid, left, right)
            return mid + left + right
        count_tree(root, p, q)
        return self.ans
        
# @lc code=end

