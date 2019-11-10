# https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归 中序遍历
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        self._preorder(result, root)
        return result

    def _preorder(self, result, root):
        if root:
            result.append(root.val)
            self._preorder(result, root.left)
            self._preorder(result, root.right)

# 非递归 使用栈实现中序遍历
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result, stack = [], [root]
        while len(stack) != 0:
            node = stack.pop()
            if node:
                result.append(node.val)
                if node.right:
                    stack.append(node.right)
                if node.left:
                    stack.append(node.left)
        return result
