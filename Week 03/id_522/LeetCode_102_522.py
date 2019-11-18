# 第3次  ，BFS   36ms
class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root: return []
        quque = [root]
        res = []
        while quque:
            level = []
            ll = len(quque)
            for i in range(ll):
                node = quque.pop(0)
                level.append(node.val)
                if node.left: quque.append(node.left)
                if node.right: quque.append(node.right)

            if level != []: res.append(level)
        return res


# 第二次  ，dfs
'''
# Definition for a binary tree node.
# class TreeNode:
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
        if not root :return []
        res=[]

        def dfs(node ,level):
            #stop
            if level==len(res):
                res.append([])

            #benceng
            if node:
                res[level].append(node.val)

            #drill down
            if node.left:
                dfs(node.left,level+1)
            if node.right:
                dfs(node.right,level+1)

        dfs(root,0)
        return res
'''

# 第一次  bfs
'''
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root :return []

        quque =[root]
        res=[[root.val]]
        level=[]
        ll=0
        #quque.append(root)

        while quque :
            ll=len(quque)
            for i in range(ll):
                node = quque.pop(0)

                if node.left:
                    quque.append(node.left)
                    level.append(node.left.val)
                if node.right:
                    quque.append(node.right)
                    level.append(node.right.val)
            if level!= []:
                res.append(level)
            level=[]

        return res
'''
