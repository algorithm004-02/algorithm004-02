/**
 * 94. 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * 1. 栈 stack           72 ms , 在所有 javascript 提交中击败了 60.02%
 * 2. 递归          68 ms , 在所有 javascript 提交中击败了 72.84%
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