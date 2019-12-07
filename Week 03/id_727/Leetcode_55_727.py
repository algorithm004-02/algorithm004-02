def largestValues(self, root: TreeNode) -> List[int]:
    res = []
    level = [root]
    while root and level:
        curr = []
        nex = []
        for node in level:
            curr.append(node.val)
            if node.left:
                nex.append(node.left)
            if node.right:
                nex.append(node.right)
        i = max(curr)
        res.append(i)
        level = nex
    return res

def largestValues(self, root: TreeNode) -> List[int]:
        maxes = []
        row = [root]
        while any(row):
            maxes.append(max(node.val for node in row))
            row = [kid for node in row for kid in (node.left, node.right) if kid]
        return maxes