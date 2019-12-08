/** 104. 二叉树的最大深度 */
/**
 * 深度优先 递归版本
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    return dfs(root, 0);
    function dfs(node, dep) {
        if (!node) return dep;
        
        let leftDep = dfs(node.left, dep + 1);
        let rightDep = dfs(node.right, dep + 1);
        
        return Math.max(leftDep, rightDep);
    }
};

/**
 * 广度优先 迭代版本
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    if (!root) return 0;
    
    let queue = [root];
    let level = 0;
    
    while(queue.length) {
        let arr = [];
        for(let i = 0; i < queue.length; i++) {
            let node = queue[i];
            
            if (!node) continue;
            
            node.left && arr.push(node.left);
            node.right && arr.push(node.right);
        }
        
        level ++;
        queue = arr;
    }
    
    return level;
};