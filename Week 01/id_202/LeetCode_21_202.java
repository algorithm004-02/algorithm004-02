package com.algorithm.qinchao.homework.week01;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
  @author zhuruihong
  @version 1.0
  @date 2019/10/17 16:34
  @description   将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
  示例：
  输入：1->2->4, 1->3->4
  输出：1->1->2->3->4->4
  来源：力扣（LeetCode）
  链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_21_202 {
    /**
     *
     * @param l1
     * @param l2
     * @description 时间复杂度 = O(n)
     */
    public ListNode mergeTwoListsByPointer(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(-1);
        //用于指针控制
        ListNode pointer = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            //指针往下移动以准备下一次的比较
            pointer = pointer.next;
        }
        if (l1 == null) {
            pointer.next = l2;
        }
        if (l2 == null) {
            pointer.next = l1;
        }
        return result.next;
    }

    /**
     *
     * @param l1
     * @param l2
     * @description 时间复杂度 = O(n)+O(m)=O(m+n)
     */
    public ListNode mergeTwoListsByRecursive(ListNode l1, ListNode l2) {
        //递归的终止条件
        if (l1 == null) {
            return l2;
            //递归的终止条件
        }else if (l2 == null) {
            return l1;
        }else if (l1.val < l2.val) {
            //它后面跟的哪个元素要它的next和当前打败仗的l2的元素再次比较才知道
            l1.next = mergeTwoListsByRecursive(l1.next, l2);
            //第一次先进这个里面证明笑到最后还是l1大胜仗了
            return l1;
        }else {
            //它后面跟的哪个元素要它的next和当前打败仗的l1的元素再次比较才知道
            l2.next = mergeTwoListsByRecursive(l1, l2.next);
            //第一次先进这个里面证明笑到最后还是l2大胜仗了
            return l2;
        }
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        LeetCode_21_202 leetCode_21_202 = new LeetCode_21_202();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(6);
        listNode2.next.next.next = new ListNode(8);

        ListNode result = leetCode_21_202.mergeTwoListsByPointer(listNode, listNode2);
        listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(5);

        listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(6);
        listNode2.next.next.next = new ListNode(8);
        ListNode result2 = leetCode_21_202.mergeTwoListsByRecursive(listNode, listNode2);
        printAll(result);
        printAll(result2);
    }

    private static void printAll(ListNode result) {
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
