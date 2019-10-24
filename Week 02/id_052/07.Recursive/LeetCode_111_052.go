package leetcode

// Time: O(n), Space: O(n)
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil { // 叶子节点返回深度为1
		return 1
	}
	if root.Left == nil { // 左子树为空，递归求右子树的最小深度
		return minDepth(root.Right) + 1
	}
	if root.Right == nil { // 右子树为空，递归求左子树的最小深度
		return minDepth(root.Left) + 1
	}

	// 左右子树都非空，递归求最小深度
	ldepth := minDepth(root.Left) + 1
	rdepth := minDepth(root.Right) + 1
	if ldepth < rdepth {
		return ldepth
	}
	return rdepth
}

// Time: O(n), Space: O(n)
func minDepthIterative(root *TreeNode) int {
	if root == nil {
		return 0
	}
	var queue []*TreeNode       // 辅助队列
	queue = append(queue, root) // 根节点入队
	depth := 1                  // 初始化深度为1

	for len(queue) > 0 { // 当队列不为空时，将队列中的元素出队
		size := len(queue)          // 当前队列中元素个数size作为限定:当前层级中节点的数量
		for i := 0; i < size; i++ { // 每次只取当前层级中的节点
			s := queue[0]     // 获取队首元素
			queue = queue[1:] // 弹出队首元素
			if s.Left == nil && s.Right == nil {
				return depth // 叶子节点直接返回当前累计深度
			}
			if s.Left != nil { // 左子树不为空把左子树入队
				queue = append(queue, s.Left)
			}
			if s.Right != nil { // 右子树不为空把右子树入队
				queue = append(queue, s.Right)
			}
		}
		depth++ // 该层级节点已经访问完，深度+1
	}
	return depth // 一定会访问叶子节点并返回，不会走到这里
}
