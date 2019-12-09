"""
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 迭代
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        queue = []
        queue.append(root)
        res = []
        
        while queue:
            tmp = []
            node = []
            for i in queue:
                node.append(i.val)
                if i.left:
                    tmp.append(i.left)
                if i.right:
                    tmp.append(i.right)
            res.append(node)
            queue = tmp
        return res

    # 递归
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root: return res
        def recursion(root, level):
            # Terminator
            if len(res) == level:
                res.append([])
            # Important
            res[level].append(root.val)
            if root.left:
                recursion(root.left, level+1)
            if root.right:
                recursion(root.right, level+1)
        recursion(root, 0)
        return res
    
    # 国际站
    def levelOrder(self, root):
        ans, level = [], [root]
        while root and level:
            ans.append([node.val for node in level])
            LRpair = [(node.left, node.right) for node in level]
            level = [leaf for LR in LRpair for leaf in LR if leaf]
        return ans

    def levelOrder(self, root):
        ans, level = [], [root]
        while root and level:
            ans.append([node.val for node in level])            
            level = [kid for n in level for kid in (n.left, n.right) if kid]
        return ans