package leetcode

/*
 * @lc app=leetcode.cn id=144 lang=golang
 *
 * [144] 二叉树的前序遍历
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
//func preorderTraversal(root *TreeNode) []int {
//	if root == nil {
//		return nil
//	}
//	r := []int{root.Val}
//	s1 := preorderTraversal(root.Left)
//	s2 := preorderTraversal(root.Right)
//	return append(append(r, s1...), s2...)
//}

func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}

	st := make([]*TreeNode, 0)
	result := make([]int, 0)
	for root != nil || len(st) != 0 {
		if root != nil {
			result = append(result, root.Val)
			st = append(st, root)
			root = root.Left
		} else {
			root = st[len(st)-1]
			root = root.Right
			st = st[:len(st)-1]
		}
	}
	return result
}

// @lc code=end
