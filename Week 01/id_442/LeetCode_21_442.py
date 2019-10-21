# https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dumy = ListNode(-1)
        r = dumy
        c1, c2 = l1, l2
        while c1 and c2:
            if c1.val <= c2.val:
                r.next = c1
                c1 = c1.next
            else:
                r.next = c2
                c2 = c2.next
            r = r.next
        r.next = c1 or c2
        return dumy.next

