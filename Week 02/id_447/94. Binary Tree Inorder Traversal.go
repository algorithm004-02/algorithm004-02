package main

import "fmt"

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
1
\
2
/
3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func main()  {
	root := &TreeNode{1, nil, nil}
	root.Right = &TreeNode{2, nil, nil}
	root.Right.Left = &TreeNode{3, nil, nil}

	fmt.Println("inOrder")
	inRes := inorderTraversal(root)
	fmt.Println(inRes)

	fmt.Println("preOrder")
	preRes := preorderTraversal(root)
	fmt.Println(preRes)
	preIteRes := preOrderTravesalIteration(root)
	fmt.Println(preIteRes)

	fmt.Println("postOrder")
	postRes := postOrderTravesal(root)
	fmt.Println(postRes)
}



// 递归实现前中后序遍历
func inorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	left := inorderTraversal(root.Left)
	right := inorderTraversal(root.Right)
	left = append(left, root.Val)
	left = append(left, right...)

	return left
}

func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	left := preorderTraversal(root.Left)
	right := preorderTraversal(root.Right)
	left = append([]int{root.Val}, left...)
	left = append(left, right...)

	return left
}

func postOrderTravesal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	left := postOrderTravesal(root.Left)
	right := postOrderTravesal(root.Right)
	left = append(left, right...)
	left = append(left, root.Val)

	return left
}


//迭代实现前中后序遍历

// 核心思想是把节点加到栈stack， 再从stack中取值，按一定逻辑放多结果集中
// 难点是加入stack，和从stack取出的逻辑



//从根节点开始，把节点放入stack中，赋值为其左子节点（中左右，左先于右，所以往左走）
// 中是第一个，所以放入栈中的同时，把中节点的值放入结果中
// 直到左子节点为空，从stack中取出，不做操作,赋值为其有子节点
// 循环
func preOrderTravesalIteration(root *TreeNode) []int {
	res := []int{}
	stack := []*TreeNode{}
	for root != nil || len(stack) != 0 {
		for root != nil  {
			res = append(res, root.Val)
			stack = append(stack, root)
			root = root.Left
		}
		root = stack[len(stack)-1]
		stack = append(stack[:len(stack)-1])
		root = root.Right
	}

	return res
}

// 从根节点开始，把节点放入stack中，节点赋值为其左子节点
// 直到节点为空，stack的最后一个即是数的最左节点，也是最左子树的根节点，取出放入到结果集中；
// 并将其赋值其右节点，循环开始的入栈操作，将该节点的下的子节点按以上逻辑放入到stack中
func inOrderTravesalIteration(root *TreeNode) []int {
	res := []int{}
	stack := []*TreeNode{}
	for root != nil || len(stack)!=0 {
		for root != nil {
			stack = append(stack, root)
			root = root.Left
		}
		root = stack[len(stack)-1]
		stack = append(stack[:len(stack)-1])
		res = append(res, root.Val)
		root = root.Right
	}

	return res
}



// ???????????????????????????????
// ???????????????????????????????
// ???????????????????????????????

func postOrderTravesalIteration(root *TreeNode) []int {
	res := []int{}
	stack := []*TreeNode{}
	for root!=nil || len(stack)!=0 {
		for root!=nil {
			stack = append(stack, root)
			root = root.Left
		}

	}

	return res
}
