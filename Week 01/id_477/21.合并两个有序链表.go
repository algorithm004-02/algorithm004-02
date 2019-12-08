package leetcode

/*
 * @lc app=leetcode.cn id=21 lang=golang
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{}
	l3 := head
	for ; l1 != nil && l2 != nil; l3 = l3.Next {
		if l1.Val < l2.Val {
			l3.Next = l1
			l1 = l1.Next
		} else {
			l3.Next = l2
			l2 = l2.Next
		}
	}
	if l1 == nil {
		l3.Next = l2
	} else {
		l3.Next = l1
	}
	return head.Next
}

// @lc code=end
