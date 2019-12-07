/*
*
* 二叉树的中序遍历
*
* 输入: [1,null,2,3]
* 输出: [1,3,2]
* 左根右
* */

/*
* 递归
* */
function inorderTraversal(root) {
    let res = []
    inorder(root, res)
    return res
}

function inorder(root, res) {
    if (!root) {
        return
    }
    inorder(root.left, res)
    res.push(root.val);
    inorder(root.right, res)
}


/*
* 栈
* */
function inorderStack(root) {
    let res = []
    let s = []
    let p = root


    while (p || s.length > 0) {
        while (p) {
            s.push(p)
            p = p.left
        }

        p = s.pop()
        res.push(p.val)
        p = p.right
    }

    return res

}






