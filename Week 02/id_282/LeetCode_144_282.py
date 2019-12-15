# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''
    给定一个二叉树，返回它的 前序 遍历。

    示例:

    输入: [1,null,2,3]  
    1
        \
        2
        /
    3 

    输出: [1,2,3]
    进阶: 递归算法很简单，你可以通过迭代算法完成吗？
    '''
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        WHITE, GRAY = 0, 1
        res = []
        stack = [(WHITE, root)]
        while stack:
            color, node = stack.pop()
            if node is None: continue
            if color == WHITE:
                stack.append((WHITE, node.right))
                stack.append((WHITE, node.left))
                stack.append((GRAY, node))
            else:
                res.append(node.val)
        return res