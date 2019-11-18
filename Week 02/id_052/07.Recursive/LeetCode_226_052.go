package leetcode

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 根节点下的左右子树互换
// 对左右子树做同样的操作 Time: O(n) Space: O(n)
func invertTree(root *TreeNode) *TreeNode {
	invert(root)
	return root
}

func invert(root *TreeNode) {
	if root != nil {
		root.Left, root.Right = root.Right, root.Left
		invert(root.Left)
		invert(root.Right)
	}
}

// 递归方法二
func invertTreeRecursive(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}
	// 交换当前根节点的左右子树
	root.Left, root.Right = root.Right, root.Left
	invertTreeRecursive(root.Left)  // 递归调用自己
	invertTreeRecursive(root.Right) // 翻转左右子树
	return root                     // 返回翻转后的二叉树
}

// 迭代
func invertTreeIterative(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}
	var queue []*TreeNode       // 定义一个队列
	queue = append(queue, root) // 根节点入队

	for len(queue) > 0 { // 当队列不为空时循环执行以下操作
		node := queue[0]  // 队列的头部元素出队
		queue = queue[1:] // 移除队列的头部元素
		// 交换当前节点的左右子树
		node.Left, node.Right = node.Right, node.Left
		if node.Left != nil { // 左子树不为空时加入队列
			queue = append(queue, node.Left)
		}
		if node.Right != nil { // 右子树不为空时加入队列
			queue = append(queue, node.Right)
		}
	}
	return root // 循环结束后返回翻转后的树
}
