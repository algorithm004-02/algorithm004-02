/**
 * Created by kaiyun on 2019/10/18.
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode rPre = result;
        while (l1 != null && l2 != null) {
            ListNode h = null;
            if (l1.val < l2.val) {
                h = l1;
                l1 = l1.next;
            } else {
                h = l2;
                l2 = l2.next;
            }
            rPre.next = h;
            rPre = h;

        }
        if (l1 != null) {
            rPre.next = l1;
        }
        if (l2 != null) {
            rPre.next = l2;
        }
        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
