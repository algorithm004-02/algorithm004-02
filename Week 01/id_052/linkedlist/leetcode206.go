package LeetCode

/**
 * Definition for singly-linked list.
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

// 迭代方法
// https://github.com/aQuaYi/LeetCode-in-Go/blob/master/Algorithms/0206.reverse-linked-list/reverse-linked-list.go
func reverseList1(head *ListNode) *ListNode {
	var pre *ListNode = nil // prev 是所有已经逆转的节点的head
	for head != nil {       // head 是下一个被逆转的节点
		next := head.Next // 先保存下一个节点，让next指向head.Next
		head.Next = pre   // 当前节点指向上一个节点，完成逆转
		pre = head        // 当前节点变为上一个节点，prev为已被逆转节点的head
		head = next       // 让head指向下一个被逆转的节点
	}
	return pre
}

// 简化
// https://github.com/NachtZ/leetcode/blob/master/206.%20Reverse%20Linked%20List.go
func reverseList2(head *ListNode) *ListNode {
	var newHead ListNode
	for head != nil {
		newHead.Next, head.Next, head = head, newHead.Next, head.Next
	}
	return newHead.Next
}

// 递归方法
func reverseList3(head *ListNode) *ListNode {
	return reverse(nil, head)
}

func reverse(pre, cur *ListNode) *ListNode {
	if cur == nil {
		return pre
	}
	head := reverse(cur, cur.Next)
	cur.Next = pre
	return head
}

func reverseList4(head *ListNode) *ListNode {
	cur, pre := head, &ListNode{} // pre 是所有已经逆转的节点
	for cur != nil {              // cur 是当前被逆转的节点
		next := cur.Next // 先保存下一个节点
		cur.Next = pre   // 逆转当前节点，使当前节点指向前一个节点
		pre = cur        // 该节点已经完成逆转
		cur = next       // 下一个将被逆转的节点
	}
	return pre // 返回完成逆转之后的头节点
}
