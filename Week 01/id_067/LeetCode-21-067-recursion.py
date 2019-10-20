class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        elif l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next , l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l2.next , l1)
            return l2
#self的用法  self.mergeTwoLists

