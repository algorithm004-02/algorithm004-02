/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
 */
// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
// 树节点
var TreeNode = /** @class */ (function () {
    function TreeNode() {
    }
    return TreeNode;
}());
var recursion = function (node, arr) {
    // 递归结束检查
    if (!node) {
        // 运行结果
        return;
    }
    // 向下递归
    recursion(node.left, arr);
    // 当前层代码逻辑
    arr.push(node.val);
    // 向下递归
    recursion(node.right, arr);
    // 恢复公共数据状态
};
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    var arr = [];
    recursion(root, arr);
    return arr;
};
// @lc code=end
