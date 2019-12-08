package leetcode

/*
 * @lc app=leetcode.cn id=104 lang=golang
 *
 * [104] 二叉树的最大深度
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
func maxDepth(root *TreeNode) int {
	return getTreeMaxDepth(root)
}

// func getTreeMaxDepth(root *TreeNode) int {
// 	if root == nil {
// 		return 0
// 	}
// 	var max, left, right int
// 	left = getTreeMaxDepth(root.Left)
// 	right = getTreeMaxDepth(root.Right)
// 	if left > right {
// 		max = left
// 	} else {
// 		max = right
// 	}
// 	return max + 1
// }

func getTreeMaxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil {
		return 1
	}
	var max int
	if root.Left != nil {
		if left := getTreeMaxDepth(root.Left); left > max {
			max = left
		}
	}
	if root.Right != nil {
		if right := getTreeMaxDepth(root.Right); right > max {
			max = right
		}
	}
	return max + 1
}

// @lc code=end

// 104 和 111 的思路一样
// 1. 如果是nil，返回0
// 2. 如果左右child是nil，返回1
// 3. 如果left child != nil，获取left child tree depth
// 4. 如果right child != nil，获取right child tree depth
// 5. 根据题目取大或者小
// 6. 再加上自己
