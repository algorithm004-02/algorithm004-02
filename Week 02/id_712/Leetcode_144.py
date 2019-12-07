class Solution:
    def preorderTraversal(self,root):
        if not root:
            return []
        preorder=[]
        stack=[root]
        while stack:
            node=stack.pop()
            preorder.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return preorder