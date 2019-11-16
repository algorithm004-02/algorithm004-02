"""429
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if not root:return []
        que=[root]
        res=[]
        while que:
            level=[]
            ll=len(que)

            for i in range(ll):
                node =que.pop(0)
                level.append(node.val)

                for k in node.children:
                    que.append(k)
            res.append(level)

        return res
