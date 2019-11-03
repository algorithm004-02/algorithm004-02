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

//  使用栈来解决，中序遍历：左-根-右
// var inorderTraversal = function (root) {
//   if (!root) return [];

//   const stack = [];
//   const result = [];

//   let node = root;

//   while (node || stack.length) {
//     if (node) {
//       stack.push(node);
//       node = node.left;
//     } else {
//       node = stack.pop();
//       result.push(node.val);
//       node = node.right;
//     }
//   }

//   return result;
// };

// 递归
var inorderTraversal = function (root) {
  const result = [];

  function inorder(root) {
    if (!root) return;
    inorder(root.left);
    result.push(root.val);
    inorder(root.right);
  }

  inorder(root);

  return result;
}
// @lc code=end