/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return prehead.next;
    }

    // 递归解法
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null) {
    //         return l2;
    //     } else if (l2 == null) {
    //         return l1;
    //     }
    //     if (l2.val < l1.val) {
    //         l2.next = mergeTwoLists(l1, l2.next);
    //         return l2;
    //     } else {
    //         l1.next = mergeTwoLists(l1.next, l2);
    //         return l1;
    //     }
    // }
}
// @lc code=end
