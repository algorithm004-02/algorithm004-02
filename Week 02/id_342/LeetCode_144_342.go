// 方法一： 递归
func preorderTraversal(root *TreeNode) []int {
    var res []int = []int{}
    if root != nil {

        l := preorderTraversal(root.Left)
        res = append(res,l...)
        r := preorderTraversal(root.Right)
        res = append(res,r...) 
        res = append(res,root.Val)
    }

    return res
}
