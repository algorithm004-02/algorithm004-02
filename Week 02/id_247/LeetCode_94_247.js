/**
 * 94. ���������������
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * 1. ջ stack           72 ms , ������ javascript �ύ�л����� 60.02%
 * 2. �ݹ�          68 ms , ������ javascript �ύ�л����� 72.84%
 */


/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
const inorderTraversal = ( root ) => {

    const stack = []
    const res = []

    while ( root || stack.length ) {

        if (root) {
            stack.push(root)
            root = root.left
        }
        else {
            root = stack.pop()
            res.push(root.val)
            root = root.right
        }
    }

    return res
};


const inorderTraversal2 = ( root ) => {

    const res = []

    const inOrder = ( node ) => {

        if (node) {
            inOrder(node.left)
            res.push(node.val)
            inOrder(node.right)
        }
    };

    if (root) inOrder(root)

    return res
}