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
	if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	}
	head := l1
	var tmp1 *ListNode

	for l1 != nil || l2 != nil {
		if l1.Val <= l2.Val {
			tmp1 = l1
			if l1.Next != nil {
				l1 = l1.Next
			} else {
				l1.Next = l2
				break
			}
			continue
		}

		if tmp1 != nil {
			tmp1.Next = &ListNode{l2.Val, l1}
			tmp1 = tmp1.Next
		} else {
			tmp1 = &ListNode{l2.Val, l1}
			head = tmp1
		}

		if l2.Next == nil {
			break
		} else {
			l2 = l2.Next
		}

	}
	return head
}

// @lc code=end
