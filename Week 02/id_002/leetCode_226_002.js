/** 226. 翻转二叉树 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 递归调用
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    return dfs(root);
    
    function dfs(node) {
        if (!node) return null;
        
        [node.left, node.right] = [node.right, node.left];
        
        dfs(node.left);
        dfs(node.right);
        
        return node;
    }
};

/**
 * 迭代法 深度优先遍历
 * 时间复杂度O(n) 空间复杂度为O(1)
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree2 = function(root) {
    let stack = [root];
    
    while(stack.length) {
        let node = stack.pop();
       
        if(!node) continue;
        
        let {left, right} = node;
        node.right = left;
        node.left = right;
        
        stack.push(left, right);
    }
    
    return root;
};