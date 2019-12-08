# DFS method RT: O(n)
def levelOrder(self, root: TreeNode) -> List[List[int]]:
        levels = []
        if root == None:
            return levels
        
        def helper(node, level):
            if len(levels) == level:
                levels.append([])

            levels[level].append(node.val)

            if node.left:
                helper(node.left, level + 1)
            if node.right:
                helper(node.right, level + 1)
            
        helper(root, 0)
        return levels


# BFS method Running time O(n)
def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        level = [root]
        
        while root and level:
            cur = []
            nex = []
            for node in level:
                cur.append(node.val)
                if node.left:
                    nex.append(node.left)
                if node.right:
                    nex.append(node.right)
            res.append(cur)
            level = nex
        
        return res