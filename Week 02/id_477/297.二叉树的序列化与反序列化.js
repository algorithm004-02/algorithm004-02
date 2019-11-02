/*
 * @lc app=leetcode.cn id=297 lang=javascript
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    let str = ""
    let serializeHelper = function(node) {
        if (!node) {
            str += "null,"
        } else {
            str += node.val + ","
            serializeHelper(node.left)
            serializeHelper(node.right)
        }
    }
    serializeHelper(root)
    return str
};



/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    let list = data.split(",")
    let deserializeHelper = function() {
        let val = list.shift()
        if (val == "null") {
            return null
        } else {
            let node = new TreeNode(Number(val))
            node.left = deserializeHelper()
            node.right = deserializeHelper()
            return node
        }
    }
    return deserializeHelper()
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
// @lc code=end