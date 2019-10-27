# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# class Solution:
#     def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
#         if l1 and l2 and l1.val >l2.val or (not l1 and l2):
#             l1,l2 = l2,l1
#         head = l1
#         if not l1 and not l2:
#             return None
#         while l1.next and l2:
#             if l1.next.val<l2.val:
#                 l1=l1.next
#             else:
#                 p = ListNode(l2.val)
#                 p.next=l1.next
#                 l1.next = p
#                 l2 = l2.next
#         if l1 and not l1.next:
#             l1.next = l2
#         return head
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2 and l1.val >l2.val or (not l1 and l2):
            l1,l2 = l2,l1
        head = l1
        if not l1 and not l2:
            return None
        while l1.next and l2:
            if l1.next.val<l2.val:
                l1=l1.next
            else:
                p = ListNode(l2.val)
                p.next=l1.next
                l1.next = p
                l2 = l2.next
        if l1 and not l1.next:
            l1.next = l2
        return head