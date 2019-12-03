#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/10/29
# @Author  : xujun


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        curr = head
        while curr != None:
            temp = curr.next
            curr.next = prev
            curr = temp
            prev = curr
        return prev
