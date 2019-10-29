/**
 * 144. ��������ǰ�����
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * 1. ջ stack           74 ms , ������ javascript �ύ�л����� 84.50%
 * 2. �ݹ�          68 ms , ������ javascript �ύ�л����� 71.96%
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