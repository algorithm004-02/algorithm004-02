/** 98. 验证二叉搜索树 **/
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 深度优先搜索
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    return dfs(root, null, null);
    
    function dfs(node, lower, upper) {
        if(!node) return true;
        
        let val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        
        if (!dfs(node.left, lower, val)) return false;
        if (!dfs(node.right, val, upper)) return false;
        
        return true;
    }
};

/**
 * 迭代法
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    let stack = [root];
    let upStack = [null];
    let loStack = [null];
    
    while(stack.length) {
        let node = stack.pop();
        let lower = loStack.pop();
        let upper = upStack.pop();
        
        if(!node) continue;
        
        let val = node.val;
        if (lower && val <= lower.val) return false;
        if (upper && val >= upper.val) return false;
        
        update(node.left, lower, node);
        update(node.right, node, upper);
    }
    
    return true;
    function update(node, lower, upper) {
        stack.push(node);
        loStack.push(lower);
        upStack.push(upper);
    }
};

/**
 * 中序遍历 递归模式
 * 时间复杂度 O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST3 = function(root) {
    let sort = [];
   
    return bfs(root);
    function bfs(node) {
        if (!node) return true;
        
        if (!bfs(node.left)) return false;
        
        sort.push(node.val);

        let len = sort.length;
        if (len > 1 && sort[len - 1] <= sort[len - 2]) return false;

        if(!bfs(node.right)) return false;

        return true;
    }
};

/**
 * 中序遍历 迭代模式
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST4 = function(root) {
    let stack = [];
    let preVal = - Number.POSITIVE_INFINITY;
    let node = root;
    
    while(stack.length || node) {
        while(node) {
            stack.push(node);
            node = node.left;
        }
        
        node = stack.pop();
        if (node.val <= preVal) return false;
        preVal = node.val;
        node = node.right;
    }
    
    return true;
}