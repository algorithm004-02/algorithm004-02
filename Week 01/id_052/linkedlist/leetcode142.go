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

func detectCycle3(head *ListNode) *ListNode {
	hash := make(map[*ListNode]int) // 哈希表记录该节点是否已遍历过，值记录节点索引
	for head != nil {
		if _, ok := hash[head]; ok { // 判断该节点是否已遍历过，形成了环
			return head
		}
		hash[head] = head.Val // 记录已经遍历过的节点
		head = head.Next
	}
	return nil
}

func detectCycle4(head *ListNode) *ListNode {
	slow, fast := head, head              // 定义快慢指针
	for fast != nil && fast.Next != nil { // 当快指针不为空，并且快指针的Next节点也不为空时
		slow, fast = slow.Next, fast.Next.Next // 满指针移动一步，快指针移动两步
		if fast == slow {                      // 判断快慢指针是否指向了同一节点
			for p := head; p != slow; {
				p = p.Next
				slow = slow.Next
			}
			return slow
		}
	}
	return nil
}
