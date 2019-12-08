package leetcode

/*
 * @lc app=leetcode.cn id=236 lang=golang
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
var res *TreeNode

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	helper(root, p, q)
	return res
}

func helper(node, p, q *TreeNode) bool {
	// termintor
	if node == nil {
		return false
	}
	var left, right, mid int

	// process current logical
	if node == q || node == p {
		mid = 1
	}

	// drill down
	if helper(node.Left, p, q) {
		left = 1
	}
	if helper(node.Right, p, q) {
		right = 1
	}

	// reverse
	if mid+left+right >= 2 {
		res = node
		return true
	}
	return mid+left+right >= 1
}

// @lc code=end
