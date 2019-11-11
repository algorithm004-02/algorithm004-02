func inorderTraversal(root *TreeNode) []int {
	var res []int = []int{}
	if root == nil {
		return nil
	}

	l := inorderTraversal(root.Left)
	res = append(l,root.Val)
	r := inorderTraversal(root.Right)
	res = append(res,r...)
	return res
}
