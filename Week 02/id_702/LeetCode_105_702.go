package leetcode

/*
 * @lc app=leetcode.cn id=105 lang=golang
 *
 * [105] 从前序与中序遍历序列构造二叉树
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

func buildTree(preorder []int, inorder []int) *TreeNode {
	inPos := make(map[int]int)
	for i := 0; i < len(inorder); i++ {
		inPos[inorder[i]] = i
	}
	return buildHelper(preorder, 0, len(preorder)-1, 0, inPos)
}

func buildHelper(pre []int, preStart, preEnd, inStart int, inPos map[int]int) *TreeNode {
	if preStart > preEnd {
		return nil
	}

	root := &TreeNode{Val: pre[preStart]}
	rootIdx := inPos[pre[preStart]]
	leftLen := rootIdx - inStart
	root.Left = buildHelper(pre, preStart+1, preStart+leftLen, inStart, inPos)
	root.Right = buildHelper(pre, preStart+leftLen+1, preEnd, rootIdx+1, inPos)
	return root
}

// @lc code=end
