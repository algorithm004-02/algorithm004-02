package study_datastructure.week_01_homework_03;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/19
 * @link
 */
public class LeetCode_21_482 {
    public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }


    /**
     *解法一：迭代法
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}
