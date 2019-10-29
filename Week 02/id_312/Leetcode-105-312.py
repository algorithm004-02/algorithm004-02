根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


##前序遍历的第一个元素为根节点，而在后序遍历中，该根节点所在位置的左侧为左子树，右侧为右子树。
##preorder 的第一个元素 3 是整棵树的根节点。inorder 中 3 的左侧 [9] 是树的左子树，右侧 [15, 20, 7] 构成了树的右子树。
##所以构建二叉shu本质上就是：
##找到各个子树的根节点 root
##构建该根节点的左子树
##构建该根节点的右子树


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        //terminator
        if len(inorder) == 0:
            return None

        //process
        # 前序遍历第一个值为root
        root = TreeNode(preorder[0])
        # 无重复元素，根据值来查找根节点在中序遍历中的位置
        mid = inorder.index(preorder[0])

        //drill
        # 构建左zi树
        root.left = self.buildTree(preorder[1:mid + 1], inorder[:mid])
        # 构建右子树
        root.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])

        return root