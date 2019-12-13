package algorithm.LeetCode;

import algorithm.util.ListNode;

/**
 * describe:
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 *
 * refrence resources: https://leetcode.com/problems/reverse-linked-list/
 *
 * @author lixilong
 * @date 2019/10/19
 */
public class _206_ReverseList {

  /*
   链接：https://www.nowcoder.com/questionTerminal/75e878df47f24fdc9dc3e400ec6058ca
   本题的关键就是在于对next域的赋值，同时对下一个节点进行保存，然后对把下一个节点赋给新的节点，这样依次循环完所有的节点。
   每次使新插入的节点变成头第一个有效节点。核心代码如下：
    next = current.next;
    current.next = reverhead;
    reverhead = current;
    current = next;
 */
  //方法1：记住这个写法即可[代码超过十行]
  public ListNode reverseList(ListNode head) {
    ListNode cur = head, pre = null, next = null;
    while (cur != null) {
      next = cur.next; // 防止断链，必须保留。暂存原链表最新头结点（当前处理节点）
      cur.next = pre;  //节点变换更新
      pre = cur;
      cur = next;
    }
    return pre; //返回新链表的尾node ；满足条件的cur赋给了pre
    // 更新头结点的判断有whlie循环来做 （当碰到原链表尾节点时才更新要返回的节点）
  }

}
