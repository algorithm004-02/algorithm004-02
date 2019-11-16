# 给定一个二叉树，返回它的中序 遍历。
# 示例:
# 输入: [1,null,2,3]
#    1
#     \
#      2
#     /
#    3
# 输出: [1,3,2]

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:                          
            return []
        
        list = []
        list += self.inorderTraversal(root.left) 
        list.append(root.val)                     
        list += self. inorderTraversal(root.right)
        return list
