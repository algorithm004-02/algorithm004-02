package LeetCode

func detectCycle1(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}
	slow, fast := head.Next, head.Next.Next
	for fast != nil && fast.Next != nil && slow != fast {
		slow, fast = slow.Next, fast.Next.Next
	}
	if slow != fast {
		return nil
	}
	// 指针从相遇点出发和从链表的头出发，最后会遍历相同数目的节点后在环的入口处相遇
	for slow != head {
		slow, head = slow.Next, head.Next
	}
	return slow
}

func detectCycle2(head *ListNode) *ListNode {
	// 步骤一：使用快慢指针判断链表是否有环
	slow, fast := head, head
	hasCycle := false
	for slow != nil && fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			hasCycle = true
			break
		}
	}
	// 步骤二：若有环，找到入环开始的节点
	if hasCycle {
		for slow != head {
			slow, head = slow.Next, head.Next
		}
		return slow
	} else {
		return nil
	}
}
