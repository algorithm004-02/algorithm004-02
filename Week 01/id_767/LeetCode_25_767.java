package algorithm.LeetCode;

import algorithm.util.ListNode;

/**
 * describe:
 *Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 *  https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * @author lixilong
 * @date 2019/10/19
 */
public class _25_ReverseKGroup {

  //方法1：记住这个写法即可[代码超过十行]
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while (curr != null && count != k) { // find the k+1 node
      curr = curr.next;
      count++;
    }
    if (count == k) { // if k+1 node is found
      curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
      // head - head-pointer to direct part,
      // curr - head-pointer to reversed part;

      while (count-- > 0) { // reverse current k-group: 轮换
        ListNode tmp = head.next; // tmp - next head in direct part
        head.next = curr; // preappending "direct" head to the reversed list
        curr = head; // move head of reversed part to a new node
        head = tmp; // move "direct" head to the next node in direct part
      }
      head = curr;
    }
    return head;
  }

}
