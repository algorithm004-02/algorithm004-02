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

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || p == nil || q == nil || root == p || root == q {
		return root
	}

	l := lowestCommonAncestor(root.Left, p, q)
	r := lowestCommonAncestor(root.Right, p, q)

	if r != nil && l != nil {
		return root
	} else if l != nil {
		return l
	} else if r != nil {
		return r
	} else {
		return nil
	}
}

//func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
//	if root == nil || p == nil || q == nil || root == p || root == q {
//		return root
//	}
//
//	left := lowestCommonAncestor(root.Left, p, q)
//	right := lowestCommonAncestor(root.Right, p, q)
//
//	if left == nil {
//		return right
//	} else if right == nil {
//		return left
//	}
//
//	return root
//}

// @lc code=end
