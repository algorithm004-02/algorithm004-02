# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:

        t=[]
        def help(root):
            if root:
                help(root.left)
                t.append(root.val)
                help(root.right)
        help(root)
        return t
