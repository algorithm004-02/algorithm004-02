/**  590. N叉树的后序遍历 */

/** 
 * 递归后续遍历
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
    let res = [];
    traverse(root, res);
    
    return res;
    
    function traverse(root) {
        if (!root) return;
        if (root.children) root.children.forEach(root => traverse(root));
        res.push(root.val);
    }
};

/**
 * 非递归后续遍历
 * @param {Node} root
 * @return {number[]}
 */
var postorder2 = function(root) {
    let stack = [root];
    let postOrder = [];
    
    while(stack.length > 0) {
        let node = stack.pop();
        postOrder.push(node.val);
        
        if (!node.children) continue;
        
        for(let i = 0; i < node.children.length; i ++) {
            stack.push(node.children[i]);
        }
    }
    return postOrder;
};

