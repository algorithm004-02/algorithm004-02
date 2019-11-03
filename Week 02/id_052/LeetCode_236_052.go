package leetcode

import "math"

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 1. 如果当前节点为空，或者等于目标节点p或q，则返回当前节点。
// 2. 否则递归到左右子树上进行处理，返回值分别为left和right。
// 3. 如果left和right非空，则说明在左右子树上各找到一个节点，于是当前的根节点就是最近公共祖先，
// 如果left和right只有一个非空，则返回哪个非空的节点，如果都为空，就返回空指针。

// 如果p、q都在二叉树中，则返回p、q二者的最近公共祖先
// 如果只有一个节点在二叉树中，则返回找到的这个节点
func lowestCommonAncestorExtend(root, p, q *TreeNode) *TreeNode {
	// 找到了一个节点，返回那个节点，或者找到了叶子节点，直接返回
	if root == nil || root == p || root == q {
		return root // 返回当前节点
	}
	// 否则递归调用自己，分别到左右子树上去处理
	// 如果该子树下包含要找的节点，那么返回该节点地址，否则返回 nil
	left := lowestCommonAncestorExtend(root.Left, p, q)
	right := lowestCommonAncestorExtend(root.Right, p, q)
	// 如果返回的结果left和right都不为空，说明左右子树上各自找到p或q节点
	if left != nil && right != nil {
		return root // 所以它们最近公共祖先就是当前节点
	} else if left != nil {
		return left
	} else if right != nil {
		return right
	}
	return nil
}

// Time: O(n), Space: O(n) n是二叉树上节点个数
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var ppath []*TreeNode // 定义p、q节点到根节点的路径
	var qpath []*TreeNode
	search(root, p, &ppath) // 在二叉树中搜索p和q
	search(root, q, &qpath) // 并把他们到根节点的路径存储起来
	// 定义游标i和两条路径中较短的路径l
	i, l := 0, int(math.Min(float64(len(ppath)), float64(len(qpath))))
	for i < l && ppath[i] == qpath[i] { // 两条路径中位置i上的节点相等时
		i++ // 不断向后移动i
	}
	// 循环结束后要不已经遍历完较短的路径，要不两条路径中位置i上的节点不相等
	return ppath[i-1] // 直接返回位置i-1上的节点即可，即p、q的最近公共祖先
}

// 辅助路径方法，辅助函数功能是在二叉树中查找一个节点到根节点的路径
func search(root, node *TreeNode, path *[]*TreeNode) bool {
	if root == nil {
		return false
	}
	*path = append(*path, root) // 当前节点加入到路径中
	if root == node {           // 如果当前节点就是要找的节点
		return true // 则返回true
	}
	// 否则取左右子树查找目标节点将他们的结果或运算
	ret := search(root.Left, node, path) || search(root.Right, node, path)
	if ret {
		return true // 找到目标节点直接返回true
	}
	// 否则说明目标节点不在当前子树中，将最后加入路径的节点移除
	*path = (*path)[:len(*path)-1]
	return false
}
