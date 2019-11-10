/** 144. 二叉树的前序遍历 */
// 2. 递归 前序遍历
var inorderTraversal = function(root) {
    let res = [];
    
    traverse(root, res);
    
    function traverse(root, res) {
        if (root) {
            res.push(root.val);
            traverse(root.left, res);
            traverse(root.right, res)
        }
    }
    
    return res;
};

/**
 * 迭代方式 前序遍历二叉树
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
    let stack =  [];
    let node = root;
    let res = []
    
    while(stack.length || node) {
        while(node) {
            res.push(node.val);
            stack.push(node);
            node = node.left;
        }
        
        node = stack.pop();
        node = node.right;
    }
    
    return res;
};