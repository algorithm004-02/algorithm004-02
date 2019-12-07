"""
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """
    翻转二叉树：
    思路：要翻转二叉树，就是左边节点和右边节点互换 node.left, node.right = node.right, node,left
       下一步：找到可以互换的节点，只要有左右节点，都可以互换
       下一步：互换的前提条件，从底部往上走，判断是否为底部，
       终止条件：node的下一层为None, not node: return
       伪代码：
       if to the end: return
       down to left tree
       down to right tree
       switch left tree and right tree
    """
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root: return
        self.invertTree(root.left)
        self.invertTree(root.right)
        root.left, root.right = root.right, root.left
        return root
