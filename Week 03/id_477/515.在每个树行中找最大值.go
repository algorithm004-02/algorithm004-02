package leetcode

/*
 * @lc app=leetcode.cn id=515 lang=golang
 *
 * [515] 在每个树行中找最大值
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
func largestValues(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	tmpres := make([][]int, 0)
	res := make([]int, 0)
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
		tmpres = append(tmpres, row)
		queue = levels
	}
	for _, row := range tmpres {
		max := row[0]
		for _, v := range row {
			if v > max {
				max = v
			}
		}
		res = append(res, max)
	}
	return res
}

// @lc code=end
