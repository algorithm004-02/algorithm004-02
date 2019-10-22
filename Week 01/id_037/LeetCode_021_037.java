// https://leetcode-cn.com/problems/merge-two-sorted-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode newList = new ListNode(Integer.MIN_VALUE);
        ListNode curr = newList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        ListNode restList = l1 == null ? l2 : l1;
        curr.next = restList;
        return newList.next;
    }
}