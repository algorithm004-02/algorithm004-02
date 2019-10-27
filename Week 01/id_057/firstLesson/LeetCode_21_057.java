package app.homework;

/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (49.40%)
 * Likes:    2769
 * Dislikes: 405
 * Total Accepted:    716.1K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * 递归，比较l1,l2的值，
     * 如果l1<l2,则在l1.next与l2中递归求下一个较小的值作为next结点，
     * 如果l1>=l2，则在l1与l2.next中递归求下一个较小的值作为next节点
     * 时间复杂度O(m+n)
     * 空间复杂度O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //递归终结条件
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代法，构造一个prehead头结点，然后维护一个pre指针，遍历时，pre的next节点指向最小的元素
     * 时间复杂度O(m+n)
     * 空间复杂度O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_by_iteration(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while (l1 != null && l2 !=null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre =pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
// @lc code=end

