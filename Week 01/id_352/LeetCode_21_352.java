/**
 * @(#)MergeTwoSortedLists.java, Oct 20, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author helloliu
 */

/**
 *题目：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *题解：
 * 1.直接遍历两个链表，比较遍历元素的大小，这种方法也是最直接的方法，时间复杂度O(m+n),m,n分别为两个链表
 *   的长度，直接遍历情况比较多，有可能存在两个链表都是空，或者某一个为空，这样会有很多多余的if else判断
 *   我们可以采用虚拟头节点的方式来规避这种操作，手动给新链表创建一个虚拟头节点
 * 2.递归：其实我们在遍历链表的过程中，只是把两个链表中较小的节点拿出来，剩下的节点其实还是两个链表，相当于
 *   我们还是做两个有序链表合并的操作，也就是说这些过程是重复的，我们可以通过递归来解决，使用递归重点是要找
 *   到合适的递归终止条件，这里条件比较简单，只要两个链表有一个为空，我们就可以不合并了
 *   note:递归是有空间消耗的
 */
public class MergeTwoSortedLists {

    public ListNode solutionOne(ListNode l1, ListNode l2) {
        //这里可能会出现l1和l2都为空，或者某一个为空的情况，情况较多，我们可以采用虚拟头节点的方法来规避
        //繁琐的if else判断
        ListNode virtualHead = new ListNode(0);
        ListNode end = virtualHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                end.next = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                l2 = l2.next;
            }
            end = end.next;
        }

        end.next = l1 == null ? l2 : l1;
        return virtualHead.next;
    }


    public ListNode solutionTwo(ListNode l1, ListNode l2) {
        //当有一个链表为空是，递归结束了
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        //都不为空
        if (l1.val >= l2.val) {
            l2.next = solutionTwo(l1, l2.next);
            return l2;
        } else {
            l1.next = solutionTwo(l1.next, l2);
            return l1;
        }

    }


}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}