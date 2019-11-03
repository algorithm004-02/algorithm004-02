package leetcode

// 二叉树的前序遍历

// 1. 递归
func preorderTraversal(root *TreeNode) []int {
	var res []int
	preorder(root, &res)
	return res
}

func preorder(root *TreeNode, output *[]int) {
	if root != nil {
		*output = append(*output, root.Val)
		preorder(root.Left, output)
		preorder(root.Right, output)
	}
}

// 2. 迭代
func preorderTraversalIterative(root *TreeNode) []int {
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
				res = append(res, cur.Val)
				prev.Right = cur
				cur = cur.Left
			} else {
				prev.Right = nil
				cur = cur.Right
			}
		}
	}
	return res
}

// 3. 迭代 Time: O(n) Space: O(n)
func preorderTraversalIterative1(root *TreeNode) []int {
	var res []int         // 定义结果list
	var stack []*TreeNode // 定义辅助栈

	for root != nil || len(stack) > 0 {
		for root != nil { // 节点不为空，把节点的值加入到结果list
			res = append(res, root.Val)
			stack = append(stack, root) // 节点压入栈
			root = root.Left            // 移动到它的左节点
		}
		root = stack[len(stack)-1] // 节点为空时，出栈
		stack = stack[:len(stack)-1]
		root = root.Right // 并把它移动到右节点
	}
	return res
}

// 4. 迭代 Time: O(n), Space: O(n)
func preorderTraversalIterative2(root *TreeNode) []int {
	var res []int
	var stack []*TreeNode
	stack = append(stack, root) // 把根节点入栈

	for len(stack) > 0 { // 栈不为空时，循环以下操作
		node := stack[len(stack)-1]  // 栈顶元素出栈
		stack = stack[:len(stack)-1] // 弹出栈顶元素
		res = append(res, node.Val)  // 节点的值加入到结果list
		if node.Right != nil {       // 若右子树不为空，则压入栈
			stack = append(stack, node.Right)
		}
		if node.Left != nil { // 若左子树不为空，则左子树压入栈
			stack = append(stack, node.Left)
		}
		// 入栈时是先右后左的顺序，出栈则先左后右，则达到根左右的顺序
	}
	return res
}
