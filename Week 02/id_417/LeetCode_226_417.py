class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        # 简单的递归即可
        if root is None:
            return None
        
        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)
        
        return root
