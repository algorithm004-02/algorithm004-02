package leetcode

/*
 * @lc app=leetcode.cn id=24 lang=golang
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	pre, head := &ListNode{Next: head}, head.Next
	for pre.Next != nil && pre.Next.Next != nil {
		cur1, cur2 := pre.Next, pre.Next.Next
		cur1.Next = cur2.Next
		cur2.Next = cur1
		pre.Next = cur2
		pre = cur1
	}
	return head
}

// @lc code=end
