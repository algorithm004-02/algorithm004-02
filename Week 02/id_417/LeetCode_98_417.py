
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # 同样是看了官方解题思路后，自己重新写了一遍
        def helper(root, lower=float("-inf"), upper=float("inf")):
            if root is None:
                return True
            
            if lower < root.val < upper:
                return True and helper(root.left, lower, root.val) and helper(root.right, root.val, upper)
            
        return helper(root)
