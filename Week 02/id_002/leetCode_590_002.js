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
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
    if (!root) return [];

    let res = [];
    let stack = [root]; 

    while(stack.length) {
        let node = stack.pop();
        res.unshift(node.val);
        let children = node.children; 


        for (let i = 0; i < children.length; i ++) {
            stack.push(children[i]);
        }
    }

    return res;
};

