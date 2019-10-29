package leetcode

/*
 * @lc app=leetcode.cn id=142 lang=golang
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func detectCycle(head *ListNode) *ListNode {
	// nodeMap := make(map[*ListNode]bool)
	// for head != nil {
	// 	if nodeMap[head] {
	// 		return head
	// 	}
	// 	nodeMap[head] = true
	// 	head = head.Next
	// }
	// return nil

	slow, fast := head, head
	for {
		if fast == nil || fast.Next == nil {
			return nil
		}
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			break
		}
	}
	fast = head
	for slow != fast {
		fast = fast.Next
		slow = slow.Next
	}
	return fast
}

// @lc code=end
