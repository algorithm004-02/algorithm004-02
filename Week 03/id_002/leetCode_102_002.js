/** 102. 二叉树的层次遍历 */

/**
 * 广度优先搜索
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    let queue = [];
    let result = [];
    
    if (root) queue.push(root);
    
    while(queue.length >0) {
        let nodes = [];
        result.push(queue.map(node => {
            if (node.left) nodes.push(node.left);
            if (node.right) nodes.push(node.right);
            return node.val
        }))
        
        queue = nodes;
    }
    
    return result;
};

/**
 * 深度优先搜索
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    let result = [];
    dfs(0, root);
    
    return result;
    
    function dfs(level, node) {
        if (!node) return;
        
        if (!result[level]) result[level] = [];
    
        result[level].push(node.val);
        dfs(level + 1, node.left);
        dfs(level + 1, node.right);     
    }
};