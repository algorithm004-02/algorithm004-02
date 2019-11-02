package leetcode

/*
 * @lc app=leetcode.cn id=98 lang=golang
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

// 以下方式测试没问题，但提交返回Testcase是[0]时报错，但手动测试没问题，懵逼了
// var pre = math.MinInt64
// func isValidBST(root *TreeNode) bool {
// 	if root == nil {
// 		return true
// 	}
// 	if !isValidBST(root.Left) {
// 		return false
// 	}
// 	if root.Val < pre {
// 		return false
// 	} else {
// 		pre = root.Val
// 	}
// 	if !isValidBST(root.Right) {
// 		return false
// 	}
// 	return true
// }
func isValidBST(root *TreeNode) bool {
	return helper(root, nil, nil)
}

func helper(root, min, max *TreeNode) bool {
	if root == nil {
		return true
	}
	if min != nil && root.Val <= min.Val || max != nil && root.Val >= max.Val {
		return false
	}
	if !helper(root.Left, min, root) {
		return false
	}
	if !helper(root.Right, root, max) {
		return false
	}
	return true
}

// @lc code=end
