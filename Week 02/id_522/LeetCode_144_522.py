# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:

        t=[]
        def help(root):
            if root:
                
                t.append(root.val)
                help(root.left)
                help(root.right)
        help(root)
        return t
