#  从前序与中序遍历序列构造二叉树

class Solution:
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        def helper(in_left = 0, in_right = len(inorder)):
            nonlocal pre_idx
            # if there is no elements to construct subtrees
            if in_left == in_right:
                return None
            
            # pick up pre_idx element as a root
            root_val = preorder[pre_idx]
            root = TreeNode(root_val)

            # root splits inorder list
            # into left and right subtrees
            index = idx_map[root_val]

            # recursion 
            pre_idx += 1
            # build left subtree
            root.left = helper(in_left, index)
            # build right subtree
            root.right = helper(index + 1, in_right)
            return root
        
        # start from first preorder element
        pre_idx = 0
        # build a hashmap value -> its index
        idx_map = {val:idx for idx, val in enumerate(inorder)} 
        return helper()


####################################################
# class Solution(object):
#     def buildTree(self, preorder, inorder):
#         """
#         :type preorder: List[int]
#         :type inorder: List[int]
#         :rtype: TreeNode
#         """
#         if len(inorder) == 0:
#             return None
#         # 前序遍历第一个值为根节点
#         root = TreeNode(preorder[0])
#         # 因为没有重复元素，所以可以直接根据值来查找根节点在中序遍历中的位置
#         mid = inorder.index(preorder[0])
#         # 构建左子树
#         root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
#         # 构建右子树
#         root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        
#         return root
