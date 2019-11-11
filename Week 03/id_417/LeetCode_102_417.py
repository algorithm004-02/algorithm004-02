# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # 和广度优先遍历不一样的是，它需要分开每一层的数据
        # 因此维护的队列成员应该是一层的元素集合而不是一个单独元素
        queue = [root]
        visited = []
        
        while queue:
            q = []
            v = []
            
            for n in queue:
                if n is None:
                    continue
                v.append(n.val)
                q.extend([n.left, n.right])
            
            if v:
                visited.append(v)
                queue = q
            else:
                break
        
        return visited
