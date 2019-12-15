"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    '''
    给定一个 N 叉树，返回其节点值的后序遍历。
    例如，给定一个 3叉树 :
    返回其后序遍历: [5,6,3,2,4,1].
    说明: 递归法很简单，你可以使用迭代法完成此题吗?
    '''
    def postorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        out = []
        stack = [root]                      #空栈初始化一个root
        while stack:
            #根 右 左
            temp = stack.pop()              #弹出来一个进行先入out 再判断是否有子节点
            out.append(temp.val)
            if temp.children:               #有子节点按照 从左到右的 方向压入栈
                for item in temp.children:
                    stack.append(item)
        return out[::-1]                    #上一步循环完后是按照 根节点 右节点 左节点 倒序输出即可
