class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        pre = ListNode(0)
        prevresult = pre
        while (l1 is not None) and (l2 is not None):
            if l1.val < l2.val:
                pre.next = l1
                l1 = l1.next
            else:
                pre.next = l2
                l2 = l2.next
            pre = pre.next
        if l1 is not None:
            pre.next = l1
        else:
            pre.next = l2
        return prevresult.next
"""
while l1 and l2 就自动遍历了吗 why
ListNode  NodeList 区别
链表是一个个节点串在一起，返回其中某一部分，直接某个节点.next 就是后面一串
"""