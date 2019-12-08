package leetcode

/*
 * @lc app=leetcode.cn id=102 lang=golang
 *
 * [102] 二叉树的层次遍历
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

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	res := make([][]int, 0)
	queue := []*TreeNode{root}
	for len(queue) > 0 {
		levels := make([]*TreeNode, 0)
		row := make([]int, 0)
		for _, node := range queue {
			row = append(row, node.Val)
			if node.Left != nil {
				levels = append(levels, node.Left)
			}
			if node.Right != nil {
				levels = append(levels, node.Right)
			}
		}
		res = append(res, row)
		queue = levels
	}
	return res
}

// @lc code=end
