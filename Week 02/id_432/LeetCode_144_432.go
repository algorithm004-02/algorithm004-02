package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	var res []int
	if (root == nil) {
		return res
	}

	res = append(res,root.Val)
	res = append(res,preorderTraversal(root.Left)...)
	res = append(res,preorderTraversal(root.Right)...)
	return res
}