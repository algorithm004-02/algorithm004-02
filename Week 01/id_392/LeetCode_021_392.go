package main

type ListNode struct {
	Val  int
	Next ListNode
}

func mergeTwoLists(l1 ListNode, l2 ListNode) ListNode {
	head := &ListNode{}
	tmp := head

	for l1 != nil || l2 != nil {
		if l1 == nil || (l2 != nil && l1.Val > l2.Val) {
			tmp.Next = l2
			tmp = l2
			l2 = l2.Next
		} else {
			tmp.Next = l1
			tmp = l1
			l1 = l1.Next
		}
	}
	return head.Next

}

func main() {
}
