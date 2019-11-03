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