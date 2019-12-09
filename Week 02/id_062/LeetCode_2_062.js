/*
* 二叉树的前序遍历
*
* 输入: [1,null,2,3]
* 输出: [1,2,3]
* 根左右
* */

/*
* 递归
* */
function preorderTraversal(root) {
    let res = []
    inorder(root, res)
    return res
}

function inorder(root, res) {
    if (!root) {
        return
    }
    res.push(root.val);
    inorder(root.left, res)
    inorder(root.right, res)
}



function inorderStack(root) {
    var stack = [root]
    var res = []
    while(stack.length > 0) {
        var item  = stack.pop()
        if(item != null) {
            res.push(item.val)
            if(item.right != null) stack.push(item.right)
            if(item.left != null) stack.push(item.left)
        }
    }
    return res
}

