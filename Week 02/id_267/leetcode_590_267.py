"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
####################递归 Recursion###########
# 1536 ms

class Solution:
    def postorder(self, root):

        res = []
        if root == None:
            return res

        def recursion(root, res):
            for child in root.children:
                recursion(child, res)
            res.append(root.val)

        recursion(root, res)
        return res

####################迭代 Iteration###########################
# 828 ms
def postorder(self, root):
        res = []
        if root == None: return res

        stack = [root]
        while stack:
            curr = stack.pop()
            res.append(curr.val)
            stack.extend(curr.children)

        return res[::-1]