class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # 简单递归即可
        if root is None:
            return 0
        
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
