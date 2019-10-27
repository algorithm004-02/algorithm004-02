package LeetCode

// 递归实现
func swapPairs(head *ListNode) *ListNode {
	// 当前无节点或者只有一个节点，无法进行交换
	if head == nil || head.Next == nil {
		return head
	}

	newHead := head.Next
	head.Next = swapPairs(newHead.Next)
	newHead.Next = head

	return newHead
}

// 方便自己理解
func swapPairs1(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	first := head           // 需要交换的第一个节点
	second := head.Next     // 需要交换的第二个节点
	third := head.Next.Next // 下一组需要交换的第一个节点

	second.Next = first           // 把第二个节点的后继指针Next指向第一个节点
	first.Next = swapPairs(third) // 把第一个节点的后继指针Next指向下一组完成交换之后的第一个节点

	return second
}
