package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
	  *     Val int
	   *     Left *TreeNode
	    *     Right *TreeNode
		 *
 }
*/
func isValidBST(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return isBST(root, math.MinInt64, math.MaxInt64)
}

func isBST(root *TreeNode, left, right int) bool {
	if root == nil {
		return true
	}
	if left >= root.Val || right <= root.Val {
		return false
	}
	return isBST(root.Left, left, root.Val) && isBST(root.Right, root.Val, right)
}
