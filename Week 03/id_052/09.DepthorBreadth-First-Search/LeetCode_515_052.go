package leetcode

import "math"

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func largestValues(root *TreeNode) []int {
	if root == nil { // 边界条件
		return []int{}
	}
	var res []int               // 定义结果集
	var queue []*TreeNode       // 定义辅助队列
	queue = append(queue, root) // 根节点入队

	if len(queue) > 0 { // 当队列不为空时循环执行
		elem := math.MinInt64       // 该层级最大元素
		size := len(queue)          // 该层级节点个数
		for i := 0; i < size; i++ { // 遍历该层级节点
			s := queue[0]     // 获取该层级队首元素
			queue = queue[1:] // 该层级队首元素出队
			if elem < s.Val { // 比较该层级节点值
				elem = s.Val // 获取该层级节点最大值
			}
			if s.Left != nil { // 左子树不为空，左子树入队
				queue = append(queue, s.Left)
			}
			if s.Right != nil { // 右子树不为空，右子树入队
				queue = append(queue, s.Right)
			}
		}
		res = append(res, elem) // 把该层级节点最大值加入结果集
	}
	return res
}

// 参考leetcode-102二叉树层序遍历
