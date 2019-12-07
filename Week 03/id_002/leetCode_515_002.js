/*** 515. 在每个树行中找最大值 ***/

/**
 * 广度优先遍历
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function(root) {
    let queue = [root];   
    if (!root) return [];  
    let max = [root.val];
    while(queue.length) {
        let tmp = [];
        for (let node of queue) {
           if (node.left) tmp.push(node.left);
           if (node.right) tmp.push(node.right);
        }
        if (tmp.length) max.push(Math.max(...tmp.map(node => node.val)));
        queue = tmp;
    }
    
    return max;
};

/**
 * 深度优先遍历
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues2 = function(root) {
    let res = [];
    dfs(0, root);
    return res;
    
    function dfs(dep, node) {
        if(!node) return;
        
        if (typeof res[dep] === 'undefined') res[dep] = node.val;
        res[dep] = node.val > res[dep]  ? node.val : res[dep];
        
        if (node.left) dfs(dep + 1, node.left);
        if (node.right) dfs(dep + 1, node.right);
    }
};