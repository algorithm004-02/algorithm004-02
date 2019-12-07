package leetcode

/*
 * @lc app=leetcode.cn id=145 lang=golang
 *
 * [145] 二叉树的后序遍历
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
//func postorderTraversal(root *TreeNode) []int {
//	if root == nil {
//		return nil
//	}
//
//	s1 := postorderTraversal(root.Right)
//	s2 := postorderTraversal(root.Left)
//	return append(append(s2, s1...), root.Val)
//}

func postorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}

	result := make([]int, 0)
	st1 := make([]*TreeNode, 0)
	st2 := make([]*TreeNode, 0)
	for root != nil || len(st2) != 0 {
		if root != nil {
			st1 = append(st1, root)
			st2 = append(st2, root)
			root = root.Right
		} else {
			root = st2[len(st2)-1]
			root = root.Left
			st2 = st2[:len(st2)-1]
		}
	}

	if len(st1) != 0 {
		for i := len(st1) - 1; i >= 0; i-- {
			result = append(result, st1[i].Val)
		}
	}

	return result
}

// @lc code=end
