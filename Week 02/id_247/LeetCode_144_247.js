/**
 * 144. 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * 1. 栈 stack           74 ms , 在所有 javascript 提交中击败了 84.50%
 * 2. 递归          68 ms , 在所有 javascript 提交中击败了 71.96%
 */

const preorderTraversal = ( root ) => {

    const stack = []
    const res = []

    while ( root || stack.length ) {

        if (root) {
            res.push(root.val)
            stack.push(root)
            root = root.left
        }
        else {
            root = stack.pop()
            root = root.right
        }
    }

    return res
}

const preorderTraversal2 = ( root ) => {

    const res = []

    const preOrder = ( node ) => {

        if (node) {
            res.push(node.val)
            preOrder(node.left)
            preOrder(node.right)
        }
    };

    if (root) preOrder(root)

    return res
}