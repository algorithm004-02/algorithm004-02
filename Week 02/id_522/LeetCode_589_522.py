"""589
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:return []
        res=[]
        stack=[]
        stack.append(root)

        while stack:
            node =stack.pop()
            res.append(node.val)

            ll=len(node.children)
            for k in range(ll):
                stack.append(node.children[ll-1-k])
        return res
