package id_432

type ListNode struct {
     Val int
     Next *ListNode
}


func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	//同题目可知，为重复子问题类题目，则可递归解决；这里一直递归，直到某一链表为空，为最终停止条件
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	if l1.Val < l2.Val {
		l1.Next = mergeTwoLists(l1.Next,l2)
		return l1
	}else{
		l2.Next = mergeTwoLists(l2.Next,l1)
		return l2
	}
}