# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    '''
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        dic = {root:None}
        def dfs(node):
            if node:
                if node.left: 
                    dic[node.left] = node
                if node.right: 
                    dic[node.right] = node
                dfs(node.left)
                dfs(node.right)
        dfs(root)
        l1, l2 = p, q
        while (l1!=l2):
            l1 = dic.get(l1, q)
            l2 = dic.get(l2, p)
        return l1 