class Solution:
    """
    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
    """
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        res,cur_level = [],[root]
        while cur_level:
            temp = []
            next_level = []
            for i in cur_level:
                temp.append(i.val)

                if i.left:
                    next_level.append(i.left)
                if i.right:
                    next_level.append(i.right)
            res.append(temp)
            cur_level = next_level
        return res