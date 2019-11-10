# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
        
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        stack = [root]                                  #初始化一个数据
        out = []
        while stack:
            temp = stack.pop()                          #先把栈顶的数据弹出来加入到 输出 集
            out.append(temp.val)
            if temp.children:                           #如果该元素有子节点children 则反转加入到 stack 里(因为是前序遍历)
                for item in temp.children[::-1]:
                    stack.append(item)
        return out

#https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/python3-fei-di-gui-jian-ming-shi-xian-by-ma-wen-bo/
