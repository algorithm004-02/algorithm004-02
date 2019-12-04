# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
        
class Solution:
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
           class Solution:

#https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/python3-fei-di-gui-jian-ming-shi-xian-by-ma-wen-2/