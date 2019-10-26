"""
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

 



 

返回其前序遍历: [1,3,5,6,2,4]。
"""
"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        ans = []
        self.recursion(root, ans)
        return ans
    
    def recursion(self, root, ans):
        if root is None:
            return
        
        if root:
            ans.append(root.val)
            
        for i in root.children:
            self.recursion(i, ans)
    
    # 第二遍
    """
    伪代码：
        define result
        define function
            function:
                if to the end: return
                add value to result
                find next node
        do function
        return result
    """
    def preorder(self, root: 'Node') -> List[int]:
        ans = []
        def recursion(root):
            if not root: return
            ans.append(root.val)
            for child in root.children:
                recursion(child)
        recursion(root)
        return ans