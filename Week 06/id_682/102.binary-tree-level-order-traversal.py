# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        levels = []

        if not root:
            return levels

        def findLevel(node, level):
            if len(levels) == level:
                levels.append([])

            levels[level].append(node.val)

            if node.left:
                findLevel(node.left, level+1)
            
            if node.right:
                findLevel(node.right, level + 1)

        findLevel(root, 0)
        return levels