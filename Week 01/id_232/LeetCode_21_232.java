package main.java.com.fans.algorithm00402.week1.homework;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 【合并两个有序链表】
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */



public class LeetCode_21_232 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;

        LeetCode_21_232 code = new LeetCode_21_232();
        ListNode res = code.mergeTwoLists(l1, l2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /* 1. 递归法   时：O(n + m)  空：O(n + m)
    *   - 寻找最小子问题
    *   - 一次递归找出链表中最小的
    * */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        if (l1.val > l2.val) {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        } else {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }
//    }

    /* 2. 双指针   时：O(n + m)  空：O(1)
    *   - 设立指针 i, j 分别指向 l1, l2， 另外创建新的head指针
    *   - 比较i 和 j的大小， 如果i < j，则head.next - > i，j++，head++。
    *   - 如果 i 和 j 其中有一个为null了， head.next -> 另一个
    * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head , i = l1, j = l2;
        while (i != null && j != null) {
            if (i.val < j.val) {
                prev.next = i;
                i = i.next;
            } else {
                prev.next = j;
                j = j.next;
            }
            prev = prev.next;
        }

        prev.next = i == null ? j : i;
        return head.next;
    }
}
