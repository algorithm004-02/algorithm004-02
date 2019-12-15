

/**
 * 590. N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * 1. 递归          684 ms , 在所有 javascript 提交中击败了 95.43%
 */

/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */



const postorder = ( root ) => {

    const res = []

    const recur = ( node ) => {

        if (node) {

            for (let i = 0; i < node.children.length; i++)
                recur(node.children[i])

            res.push(node.val)
        }
    };

    if (root) recur(root)

    return res
};