/*
 * @lc app=leetcode id=105 lang=javascript
 *
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    // ------------------------- 解法 1 start --------------------------
    // 最好记  👍 👍 👍 👍 👍
    // 最优解  😘 😘 😘 😘 😘
    p = i = 0
    build = function(stop) {
        if (inorder[i] != stop) {
            var root = new TreeNode(preorder[p++])
            root.left = build(root.val)
            i++
            root.right = build(stop)
            return root
        }
        return null
    }
    return build()
};
// @lc code=end

