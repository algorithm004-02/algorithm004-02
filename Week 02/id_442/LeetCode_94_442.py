# https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归中序遍历
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        self._inorder(result, root)
        return result

    def _inorder(self, result, root):
        if root:
            self._inorder(result, root.left)
            result.append(root.val)
            self._inorder(result, root.right)


# 非递归 用栈实现中序遍历
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result, stack = [], []
        current = root
        while current or len(stack) != 0:
            while current:
                stack.append(current)
                current = current.left
            current = stack.pop()
            result.append(current.val)
            current = current.right
        return result
