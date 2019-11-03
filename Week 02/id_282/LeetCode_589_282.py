"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    '''
    给定一个 N 叉树，返回其节点值的前序遍历。
    '''
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        list = []
        #根,左,右
        list.append(root.val)
        if root.children:
            for item in root.children:
                list += self.preorder(item)
        return list
