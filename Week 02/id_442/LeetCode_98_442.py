# https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # 中序遍历 记录上一个节点的值 判断是否递增即可
        self.last = None
        def valid(root: TreeNode):
            if not root:
                return True
            if not valid(root.left):
                return False
            if self.last and self.last.val >= root.val:
                return False
            self.last = root
            return valid(root.right)
        return valid(root)
