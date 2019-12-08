/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
 */
// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
// 二叉树节点
var TreeNodePre = /** @class */ (function () {
    function TreeNodePre() {
    }
    return TreeNodePre;
}());
var recursionPre = function (node, arr) {
    // 递归结束检查
    if (!node) {
        // 运行结果
        return;
    }
    // 当前层代码逻辑
    arr.push(node.val);
    // 向下递归
    recursionPre(node.left, arr);
    recursionPre(node.right, arr);
};
/**
 * @param {TreeNodeIn} root
 * @return {number[]}
 */
var preorderTraversal = function (root) {
    var arr = [];
    recursionPre(root, arr);
    return arr;
};
// @lc code=end
