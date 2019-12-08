package leetcode

/*
 * @lc app=leetcode.cn id=94 lang=golang
 *
 * [94] 二叉树的中序遍历
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
//func inorderTraversal(root *TreeNode) []int {
//	if root == nil {
//		return nil
//	}
//
//	s1 := inorderTraversal(root.Left)
//	s2 := inorderTraversal(root.Right)
//	return append(append(s1, root.Val), s2...)
//}

func inorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}

	st := make([]*TreeNode, 0)
	result := make([]int, 0)
	for root != nil || len(st) != 0 {
		if root != nil {
			st = append(st, root)
			root = root.Left
		} else {
			root = st[len(st)-1]
			st = st[:len(st)-1]
			result = append(result, root.Val)
			root = root.Right
		}
	}
	return result
}

// @lc code=end
