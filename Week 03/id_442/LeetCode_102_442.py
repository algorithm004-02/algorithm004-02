# https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归实现层序遍历 本质上还是DFS
# 只不过在递归过程中传递层数把每层的元素记录到一组
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        result = []

        def helper(node: TreeNode, level: int):
            if len(result) == level:
                result.append([])
            result[level].append(node.val)
            if node.left:
                helper(node.left, level + 1)
            if node.right:
                helper(node.right, level + 1)

        helper(root, 0)
        return result


# 非递归实现 使用队列完成
from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        result, level = [], 0
        queue = deque([root])
        while queue:
            result.append([])
            for i in range(len(queue)):
                node = queue.popleft()
                result[level].append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            level += 1
        return result


# 使用Python强大的列表推导完成 5行代码!
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result, level = [], [root]
        while root and level:
            result.append([node.val for node in level])
            level = [kid for n in level for kid in (n.left, n.right) if kid]
        return result
