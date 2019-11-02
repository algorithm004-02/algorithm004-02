

/**
 * N叉树的后序排列
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
var postorder = function(root) {
    const stack = [root];
    const arr = [];
    while (stack.length && root !== null) {
        let node = stack.pop();
        for (let i = 0; i < node.children.length; i++) {
            stack.push(node.children[i]);
        }
        arr.unshift(node.val)
    }
    return arr;
};