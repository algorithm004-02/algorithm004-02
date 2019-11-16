package algorithm.LeetCode;

import algorithm.util.ListNode;

/**
 * describe:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author lixilong
 * @date 2019/10/19
 */
public class _142_DetectCycle {

  //方法1：找重合，对其找环入口，【长度为l+k的窗口】
  public ListNode reverseList(ListNode head) {
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null){// 判断有无环
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){// 重合表示有环  //也可用set 方式判断 ，参见141

        slow = head;// p1重新出发，p1、p2每次都走一步，如果重合，重合处必为环的入口[但并不一定是最快相遇方式]
        while(slow!=fast){
          slow = slow.next;
          fast = fast.next;  //相当于把块节点拉到相遇节点，慢节点拉到起点【长度为l+k的窗口】
        }
        return slow;
      }
    }
    return null;
  }

}
