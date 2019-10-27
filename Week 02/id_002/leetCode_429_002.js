/** 429. N叉树的层序遍历 */

/**
 * 递归方式 层序遍历
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    let res = [];
    let deep = 0;
    
    traverse(root, deep);
    return res;
    
    function traverse(node, deep) {
        if (!node) return;
        
        !(res[deep]) ? (res[deep] = [node.val]) : res[deep].push(node.val);
        
        node.children && node.children.forEach(node => traverse(node, deep + 1));
    }
}