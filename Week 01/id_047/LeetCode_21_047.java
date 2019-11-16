public class LeetCode_21_047 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode headForNew = null;
        if (l1 == null && l2 == null) {
            return headForNew;
        }

        ListNode currNodeForNew = null;

        if (l1 == null || l2 == null) {
            ListNode usageList = l1 == null ? l2 : l1;
            ListNode currNodeForUsage = usageList;
            headForNew = new ListNode(usageList.val);
            currNodeForNew = headForNew;

            while (currNodeForUsage.next != null) {
                currNodeForNew.next = new ListNode(currNodeForUsage.next.val);
                currNodeForNew = currNodeForNew.next;
                currNodeForUsage = currNodeForUsage.next;
            }
            return headForNew;
        }


        ListNode currNodeForL1 = l1;
        ListNode currNodeForL2 = l2;

        int headVal1 = currNodeForL1.val;
        int headVal2 = currNodeForL2.val;
        if (headVal1 <= headVal2) {
            headForNew = new ListNode(headVal1);
            currNodeForL1 = currNodeForL1.next;
        } else {
            headForNew = new ListNode(headVal2);
            currNodeForL2 = currNodeForL2.next;
        }
        currNodeForNew = headForNew;

        while (currNodeForL1 != null && currNodeForL2 != null) {

            int val1 = currNodeForL1.val;
            int val2 = currNodeForL2.val;

            if (val1 <= val2) {
                currNodeForNew.next = new ListNode(val1);
                currNodeForL1 = currNodeForL1.next;
            } else {
                currNodeForNew.next = new ListNode(val2);
                currNodeForL2 = currNodeForL2.next;
            }
            currNodeForNew = currNodeForNew.next;
        }

        while (currNodeForL1 != null) {
            currNodeForNew.next = new ListNode(currNodeForL1.val);
            currNodeForNew = currNodeForNew.next;
            currNodeForL1 = currNodeForL1.next;
        }

        while (currNodeForL2 != null) {
            currNodeForNew.next = new ListNode(currNodeForL2.val);
            currNodeForNew = currNodeForNew.next;
            currNodeForL2 = currNodeForL2.next;
        }

        return headForNew;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
}