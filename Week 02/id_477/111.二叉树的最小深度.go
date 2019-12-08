package leetcode

import "math"

/*
 * @lc app=leetcode.cn id=111 lang=golang
 *
 * [111] 二叉树的最小深度
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
func minDepth(root *TreeNode) int {
	return getTreeMinDepth(root)
}

func getTreeMinDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil {
		return 1
	}
	var min = math.MaxInt64
	if root.Left != nil {
		if left := getTreeMinDepth(root.Left); left < min {
			min = left
		}
	}
	if root.Right != nil {
		if right := getTreeMinDepth(root.Right); right < min {
			min = right
		}
	}
	return min + 1
}

// @lc code=end
