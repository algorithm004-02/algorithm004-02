/********* 一种范式解法 ********/

// 1. 递归 中序遍历
var inorderTraversal2 = function(root) {
    let res = [];
        
    function traverse(root, res) {
        if (root) {
            traverse(root.left, res);
            res.push(root.val);
            traverse(root.right, res)
        }
    }
    
    return res;
};

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

// 2. 递归 后续遍历
var inorderTraversal = function(root) {
    let res = [];
    
    traverse(root, res);
    
    function traverse(root, res) {
        if (root) {
            traverse(root.left, res);
            traverse(root.right, res);
            res.push(root.val);   
        }
    }   
    return res;
};