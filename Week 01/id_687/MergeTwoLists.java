package com.itliusir.linkedlist;

import com.itliusir.util.ListNode;
import com.itliusir.util.PrintListUtil;

/**
 * problem.21
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author liugang
 * @date 2019-10-20
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = new MergeTwoLists().mergeTwoListsTwo(l1, l2);
        PrintListUtil.printList(res);
    }

    /**
     * method 1 -> time O(l1.length + l2.length) space O(l1.length + l2.length)
     * <p>
     * recursively
     *
     * @author liugang
     * @date 2019-10-20 13:14:17
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * method 2 -> time O(l1.length + l2.length) space O(1)
     *
     * iteratively
     * 使用头指针来串联一个新的链表
     * head -> min(l1,l2) -> ....
     * @author liugang
     * @date 2019-10-20 16:27:24
     */
    public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        // l1 null;l2 null
        prev.next = l1 == null ? l2 : l1;
        // remove head
        return preHead.next;
    }

}
