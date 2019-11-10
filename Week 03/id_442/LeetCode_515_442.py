# https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# DFS实现层序遍历 每次递归传递层数 找到每层最大的值
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        result = []

        def helper(node: TreeNode, level: int):
            if len(result) == level:
                result.append(node.val)
            else:
                result[level] = max(result[level], node.val)
            if node.left:
                helper(node.left, level + 1)
            if node.right:
                helper(node.right, level + 1)

        helper(root, 0)
        return result


from collections import deque

# 层序遍历 BFS实现 每层找到当前层的最大值
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return
        result, queue = [], deque([root])
        while queue:
            max_val = queue[0].val
            for i in range(len(queue)):
                node = queue.popleft()
                max_val = max(node.val, max_val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(max_val)
        return result

