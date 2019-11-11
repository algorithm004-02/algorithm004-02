/** 111. 二叉树的最小深度 **/

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 深度优先 递归版
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {number}
 */
 var minDepth = function(root) {
    return dfs(root, 0);
    
    function dfs(node, dep) {
        if (!node) return dep;
        
        let leDep = dfs(node.left, dep + 1);
        let riDep = dfs(node.right, dep + 1);
        
        if (node.left && node.right) {
            return Math.min(leDep, riDep);
        } else if (node.left || node.right) {
            return node.left ? leDep : riDep;
        } else {
            return dep + 1;
        }
    }
};
 
