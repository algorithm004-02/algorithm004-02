
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;

        // l1与l2都有值
        while (l1 != null && l2 != null) {
            // 小的插入的新链表，同时后移
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        // 剩余的拼接到新链表
        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}
