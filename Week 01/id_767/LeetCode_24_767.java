package algorithm.LeetCode;

import algorithm.util.ListNode;

/**
 * describe:
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 *
 *https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * @author lixilong
 * @date 2019/10/19
 */
public class _24_SwapPairs {
  //方法1：
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode lead = dummy;
    while (head != null && head.next != null) {
      lead.next = head.next;
      head.next = head.next.next;

      lead.next.next = head;

      lead = head;
      head = head.next;   //交换之后
    }
    return dummy.next;
  }




}
