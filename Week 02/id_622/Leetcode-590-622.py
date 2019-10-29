"""
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

 



 

返回其后序遍历: [5,6,3,2,4,1].

 

说明: 递归法很简单，你可以使用迭代法完成此题吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        ans = []
        self.recursion(root, ans)
        return ans
    
    def recursion(self, root, ans):
        if root is None:
            return
        for i in root.children:
            if i:
                self.recursion(i, ans)
        ans.append(root.val)
    

    # 第二遍
    """
       ans = []
       def recursion:
           if to the end: return
           for child in children:
               if child is not empty:
                   go down: recursion
            add to result
        do recursion
        return ans
    """
    def postorder(self, root: 'Node') -> List[int]:
        ans = []
        def recursion(root):
            if not root: return
            for child in root.children:
                if child:
                    recursion(child)
            ans.append(root.val)
        recursion(root)
        return ans