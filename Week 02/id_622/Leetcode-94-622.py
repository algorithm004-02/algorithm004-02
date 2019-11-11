"""
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None: return
        ans = []
        self.recursion(root, ans)
        return ans
    
    def recursion(self, root, ans):
        if root is not None:
            if root.left is not None:
                self.recursion(root.left, ans)    
            ans.append(root.val)
            if root.right is not None:
                self.recursion(root.right, ans)

    # 第二遍
    # 与第一遍不同，函数内定义函数，且Terminator修改为is None返回
    def inorderTraversal1(self, root: TreeNode) -> List[int]:
        ans = []
        def recursion(root):
            if root is None: return
            recursion(root.left)
            ans.append(root.val)
            recursion(root.right)   
        recursion(root)
        return ans

    # 迭代法
    def inorderTraversal2(self, root: TreeNode) -> List[int]:
        ans = []
        stack = []
        p = root
        while p or stack:
            # 把p的左子树入栈
            while p:
                stack.append(p)
                p = p.left
            # p为空时，则开始出栈
            p = stack.pop()
            ans.append(p.val)
            p = p.right
        return ans