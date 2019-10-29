package leetcode

// 二叉树的中序遍历

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversalRecursive(root *TreeNode) []int {
	var res []int
	inorder(root, &res)
	return res
}

func inorder(root *TreeNode, output *[]int) {
	if root != nil {
		inorder(root.Left, output)
		*output = append(*output, root.Val)
		inorder(root.Right, output)
	}
}

// Time: O(n). Space: O(n) 最好情况下树的高度最小是O(logn)
func inorderTraversal(root *TreeNode) []int {
	if root == nil { // 树为空时返回空的list
		return []int{}
	}
	left := inorderTraversal(root.Left) // 递归遍历左右子树
	right := inorderTraversal(root.Right)
	left = append(left, root.Val) // 左子树遍历的结果和根节点拼接
	left = append(left, right...) // 再拼接右子树遍历的结果
	return left                   // 返回结果
}

// Time: O(n). Space: O(n)
func inorderTraversalIterative(root *TreeNode) []int {
	var stack []*TreeNode // 辅助栈
	var res []int         // 保存结果的list

	for root != nil || len(stack) > 0 {
		for root != nil { // 树的左节点不为空时压入栈
			stack = append(stack, root)
			root = root.Left
		}
		root = stack[len(stack)-1]   // 当前栈顶元素
		stack = stack[:len(stack)-1] // 栈顶元素出栈
		res = append(res, root.Val)  // 加入结果list
		root = root.Right            // root移动到它的右节点
	}
	return res // 循环结束后返回结果list
}

// 不使用辅助栈的迭代方法
func inorderTraversalIterativeList(root *TreeNode) []int {
	var res []int
	if root == nil {
		return res
	}
	cur := root
	for cur != nil {
		if cur.Left == nil {
			res = append(res, cur.Val)
			cur = cur.Right
		} else {
			prev := cur.Left
			for prev.Right != nil && prev.Right != cur {
				prev = prev.Right
			}
			if prev.Right == nil {
				prev.Right = cur
				cur = cur.Left
			} else {
				prev.Right = nil
				res = append(res, cur.Val)
				cur = cur.Right
			}
		}
	}

	return res
}
