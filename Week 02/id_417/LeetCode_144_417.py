class Solution:
    def preorderTraversal(self, root: TreeNode):
        result = []
        if root is None:
            return result
        
        result.append(root.val)
        result.extend(self.preorderTraversal(root.left))
        result.extend(self.preorderTraversal(root.right))
        
        return result
