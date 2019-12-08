
/**
 * 102.二叉树的层序遍历 高频
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    
    //非递归做法
    if (!root) return []
    const arr = [root], result = []
    while (arr.length) {
        const size = arr.length, values = []
        for (let i = 0; i < size; i++) {
            //shift() 方法用于把数组的第一个元素从其中删除，并返回第一个元素的值。
            const node = arr.shift()
            values.push(node.val)
            //左右节点存在就加进去，继续走
            if (node.left) arr.push(node.left) 
            if (node.right) arr.push(node.right) 
        }
        result.push(values)
    }
    return result
    
};