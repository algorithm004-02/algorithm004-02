"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    '''
    给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
    说明:

    树的深度不会超过 1000。
    
    
    用了一个前序遍历，先添加当前节点的值再按顺序对子节点进行相同操作。
    因为事先并不知道树的深度所有才有了那个try except语句，至于except中用直接用append是因为上一层必然是存在的，
    所以我们添加下一层直接append就好。而这里并不需要担心顺序问题，因为我们的append和函数一样是优先访问左下节点然后再到右下节点的。

    '''

    def levelOrder(self, root: 'Node') -> List[List[int]]:
        ans = []
        def layer(root, ans, n_layer=0):
            if root:
                try:
                    ans[n_layer].append(root.val)
                except IndexError:
                    ans.append([root.val])
                for i in root.children:
                    layer(i, ans, n_layer+1)
        layer(root, ans)
        return ans