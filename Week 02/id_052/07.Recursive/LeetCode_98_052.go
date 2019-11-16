package leetcode

import "math"

// Time: O(n*log(n)), Space: O(n)
func isValidBST(root *TreeNode) bool {
	if root == nil {
		return true
	}
	leftValid, rightValid := false, false
	if root.Left == nil || root.Val > max(root.Left).Val {
		leftValid = true // 证明根节点左侧是有效的
	}
	if root.Right == nil || root.Val < min(root.Right).Val {
		rightValid = true // 证明根节点右侧是有效的
	}
	// 对于当前根节点左右子树都是有效的并且左右子树都是二叉树
	return leftValid && rightValid && isValidBST(root.Left) && isValidBST(root.Right)
}

// 返回最小值的叶子节点
func min(root *TreeNode) *TreeNode {
	for root.Left != nil {
		root = root.Left
	}
	return root
}

// 返回最大值的叶子节点
func max(root *TreeNode) *TreeNode {
	for root.Right != nil {
		root = root.Right
	}
	return root // 最后返回叶子节点
}

// 自顶向下，利用上下界进行约束的方法 Time: O(n), Space: O(n)
func isValidBST1(root *TreeNode) bool {
	return isValidBSTBound(root, nil, nil)
}
func isValidBSTBound(root, lower, upper *TreeNode) bool {
	if root == nil {
		return true
	}
	if lower != nil && lower.Val >= root.Val {
		return false
	}
	if upper != nil && upper.Val <= root.Val {
		return false
	}
	return isValidBSTBound(root.Left, lower, root) && isValidBSTBound(root.Right, root, upper)
}

// 递归的优化
func isValidBST2(root *TreeNode) bool {
	return isBST(root, math.MinInt64, math.MaxInt64)
}
func isBST(root *TreeNode, left, right int) bool {
	if root == nil {
		return true
	}
	if left >= root.Val || right <= root.Val {
		return false
	}
	return isBST(root.Left, left, root.Val) && isBST(root.Right, root.Val, right)
}
