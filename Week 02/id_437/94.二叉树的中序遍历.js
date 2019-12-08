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
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
  let list = []
  let stack = []
  let cur = root

  while (!!cur) {
    while (cur !== null) {
      stack.push(cur)
      cur = cur.left
    }
    cur = stack.pop()
    list.push(cur.val)
    cur = cur.right
  }
  return list
};

// @lc code=end

