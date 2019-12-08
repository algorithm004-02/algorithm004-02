package leetcode

import "container/list"

// 二叉树后序遍历: 左右根的顺序访问Time: O(n), Space: O(n)
func postorderTraversal(root *TreeNode) []int {
	var res []int
	postorder(root, &res)
	return res
}

func postorder(root *TreeNode, output *[]int) {
	if root != nil {
		postorder(root.Left, output)
		postorder(root.Right, output)
		*output = append(*output, root.Val)
	}
}

// 入栈当前节点，然后不断访问左子树
// 当左子树为空时，将它移动到栈顶节点的右节点
// 记录上一个出栈的节点变量pre，说明已经处理过
func postorderTraversalIterative(root *TreeNode) []int {
	var res []int         // 定义结果列表
	var stack []*TreeNode // 定义辅助栈
	pre := new(TreeNode)  // 记录上一次出栈的节点

	for root != nil || len(stack) > 0 {
		if root != nil { // 当前节点不为空
			stack = append(stack, root) // 入栈
			root = root.Left            // 移动到它的左子树
		} else { // 当前节点为空，看栈顶节点的右节点
			root = stack[len(stack)-1].Right
			if root == nil || root == pre { // 为空，或已出栈
				pre = stack[len(stack)-1]    // 把栈顶元素存储到pre
				stack = stack[:len(stack)-1] // 弹出栈顶元素
				res = append(res, pre.Val)   // 加入到结果列表
				root = nil                   // 避免因为root等于pre而进入这条语句
			}
		}
	}
	return res
}

// 使用链表存储结构，在O(1)时间复杂度向头部插入结果
func postorderTraversalIterativeList(root *TreeNode) []int {
	l := list.New() // 定义结果链表
	if root == nil {
		return []int{}
	}
	var stack []*TreeNode
	stack = append(stack, root)

	for len(stack) > 0 {
		node := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		l.PushFront(node.Val)
		if node.Left != nil { // 入栈先左后右
			stack = append(stack, node.Left)
		}
		if node.Right != nil {
			stack = append(stack, node.Right)
		}
		// 出栈就是先右后左
	}
	var res []int
	for e := l.Front(); e != nil; e = e.Next() {
		res = append(res, e.Value.(int))
	}
	return res
}

// 不使用链表，反转结果list得到后序遍历
func postorderTraversalStack(root *TreeNode) []int {
	stack := make([]*TreeNode, 0)
	output := make([]int, 0)
	if root == nil {
		return output
	}
	stack = append(stack, root)
	for len(stack) > 0 {
		node := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		output = append(output, node.Val)
		if node.Left != nil {
			stack = append(stack, node.Left)
		}
		if node.Right != nil {
			stack = append(stack, node.Right)
		}
	}
	reverse(output)
	return output
}

func reverse(arr []int) {
	i, j := 0, len(arr)-1
	for i < j {
		arr[i], arr[j] = arr[j], arr[i]
		i++
		j--
	}
}
