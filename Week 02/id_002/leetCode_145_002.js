/** 145. 二叉树的后序遍历 **/

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 后序遍历 递归
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
    return dfs(root, []);
    
    function dfs(node, res) {
        if (!node) return res;
        
        dfs(node.left, res);
        dfs(node.right, res);
        res.push(node.val);
        
        return res;
    }
};