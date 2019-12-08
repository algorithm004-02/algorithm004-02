#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/10/30
# @Author  : xujun
# 两两交换链表中的节点
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# 递归解法
# class Solution:
#     def swapPairs(self, head: ListNode) -> ListNode:
#         if not (head and head.next):
#             return head
#         next = head.next
#         head.next = self.swapPairs(next.next)
#         next.next = head
#         return next


# 迭代解法
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        prev = ListNode(0)
        prev.next = head
        c = prev
        while c.next and c.next.next:
            a, b = prev.next, c.next.next
            c.next, a.next = b, b.next
            b.next = a
            c = a
        return head.next
