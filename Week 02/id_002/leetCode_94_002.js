/********* 一种范式解法 ********/

/**
 * 递归 中序遍历
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
    return dfs(root, []);
    function dfs(node, res) {
        if(!node) return;
        
        dfs(node.left, res);
        res.push(node.val);
        dfs(node.right, res);
        
        return res;
    }
};

/**
 * 迭代法中序遍历
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal2 = function(root) {
    let stack = [];
    let node = root;
    let res = [];
    
    while(stack.length || node) {
        while(node) {
            stack.push(node);
            node = node.left;
        }
        
        node = stack.pop();
        res.push(node.val);
        node = node.right;
    }
    
    return res;
};