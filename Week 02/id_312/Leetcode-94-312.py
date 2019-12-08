给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,3,2]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#一种颜色标记的方法-----henry
#使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
#如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
#如果遇到的节点为灰色，则将节点的值输出。

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        WHITE, GRAY = 0, 1
        res = []
        stack = [(WHITE, root)]
        while stack:
            color, node = stack.pop()
            if node is None: continue
            if color == WHITE:
                stack.append((WHITE, node.right))
                stack.append((GRAY, node))
                stack.append((WHITE, node.left))
            else:
                res.append(node.val)
        return res

#左 根 右
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        r, stack = [], []
        while True:
            while root:
                stack.append(root)
                root = root.left
            if not stack:
                return r
            node = stack.pop()
            r.append(node.val)
            root = node.right
        return r
