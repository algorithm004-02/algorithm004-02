package LeetCode

// 快慢指针实现 Time Complexity: O(n) Space Complexity: O(1)
func hasCycle1(head *ListNode) bool {
	fast := head // 快指针
	slow := head // 慢指针
	for fast != nil && fast.Next != nil {
		slow = slow.Next      // 满指针移动一步
		fast = fast.Next.Next // 快指针移动两步
		if slow == fast {     // 判断快慢指针是否指向了同一节点
			return true
		}
	}
	return false
}

// 哈希表实现
// 将遍历过的节点记录下来，如果又遍历到了，表示链表有环，时间复杂度O(n)，空间复杂度O(n)
func hasCycle3(head *ListNode) bool {
	hash := make(map[*ListNode]int) // 哈希表记录该节点是否已遍历过，值记录节点索引
	for head != nil {
		if _, ok := hash[head]; ok { // 判断该节点是否已遍历过，形成了环
			return true
		}
		hash[head] = head.Val // 记录已经遍历过的节点
		head = head.Next
	}
	return false
}
