/**  589. N叉树的前序遍历 */

/**
 * 递归调用
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
    let res = [];
    
    traverse(root);
    
    return res;
    function traverse(node) {
        if (!node) return;
        res.push(node.val);
        if (!node.children) return;
        node.children.forEach(node => traverse(node));
    }
};

/**
 * 非递归遍历
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
    let stack = [root];
    let res = [];
    
    while(stack.length > 0) {
        let node = stack.pop();
        if (!node) return res;
        
        res.push(node.val);
        
        if (!node.children) continue;
        
        for(let i = node.children.length - 1; i >= 0; i --) {
            stack.push(node.children[i]);
        }
    }
    
    return res;
};