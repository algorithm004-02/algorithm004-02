package leetcode

// 二叉树的层次遍历 Time: O(n), Space: O(n)
func levelOrder(root *TreeNode) [][]int {
	if root == nil { // 边界条件
		return [][]int{}
	}
	var result [][]int          // 定义层序遍历结束
	var queue []*TreeNode       // 定义辅助队列
	queue = append(queue, root) // 根节点入队

	for len(queue) > 0 { // 当队列不为空时循环执行
		var elem []int     // 保存该层级访问的元素
		size := len(queue) // 当前队列大小，即当前层级中节点的个数
		for i := 0; i < size; i++ {
			s := queue[0] // 队首节点出队
			queue = queue[1:]
			elem = append(elem, s.Val) // 加入该层级list
			if s.Left != nil {         // 左子树不为空，入队
				queue = append(queue, s.Left)
			}
			if s.Right != nil { // 右子树不为空，入队
				queue = append(queue, s.Right)
			}
		}
		result = append(result, elem) // 该层级list加入到结果集
	}
	return result
}
