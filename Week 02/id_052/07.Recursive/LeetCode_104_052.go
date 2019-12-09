package leetcode

import "math"

// 找出终止条件：当前节点为空
// 找出返回值：节点为空时说明高度为0，所以返回0；节点不为空时则分别求左右子树的高度的最大值，同时加1表示当前节点的高度，返回该数值
// 某层的执行过程：在返回值部分基本已经描述清楚
// 时间复杂度: O(n)，其中n是节点的数量
// 空间复杂度，在最糟糕的情况下，树是完全不平衡的，例如每个节点只剩下左子节点，递归将会被调用N次(树的高度)，因此保持调用栈的存储将是O(N)。但在最好的情况下(平衡二叉树)，树的高度是log(N)，所以在这种情况下的空间复杂度是O(logN)。
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	ldepth := maxDepth(root.Left) + 1
	rdepth := maxDepth(root.Right) + 1
	if ldepth > rdepth {
		return ldepth
	}
	return rdepth
}

// 递归的优化 Time: O(n), Space: O(n)
func maxDepth1(root *TreeNode) int {
	if root == nil { // 如果当前根节点为空
		return 0 // 则返回深度为0
	}
	// 递归求左右子树的深度，取最大值
	return int(math.Max(float64(maxDepth(root.Left)), float64(maxDepth(root.Right)))) + 1
}

// 迭代的方法，层序遍历树得到深度 Time: O(n) Space: O(n)
func maxDepth2(root *TreeNode) int {
	if root == nil {
		return 0
	}
	var queue []*TreeNode       // 辅助队列
	queue = append(queue, root) // 根节点入队
	depth := 0                  // 初始化深度为0

	for len(queue) > 0 { // 当队列不为空时，循环以下操作
		size := len(queue)
		for i := 0; i < size; i++ { // 遍历当前层级中的节点
			s := queue[0]      // 获取队首元素
			queue = queue[1:]  // 队首元素出队
			if s.Left != nil { // 如果左子树不为空，左子树入队
				queue = append(queue, s.Left)
			}
			if s.Right != nil { // 如果右子树不为空，右子树入队
				queue = append(queue, s.Right)
			}
		}
		depth++ // for循环结束后这一层级节点已经访问结束，深度加+1
	}
	return depth
}
