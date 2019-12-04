/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    let res = [];
    recursion(0, root, res)
    return res
};

var recursion = function(k, node, res) {
    if (!node) {
        return;
    }
    if (!res[k]) {
        res[k] = [];
    }
    res[k].push(node.val)
    for (let i = 0; i < node.children.length; i++) {
        recursion(k + 1, node.children[i], res)
    }
};
// @lc code=end