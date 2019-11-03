import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class Solution {

    public void printList(ListNode l){
        while(l != null){
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

    //自己的解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeListHeader = null;
        ListNode mergeListTailer = null;
        if (l1 == null){
           return l2;
        }
        if (l2 == null){
            return l1;
        }

        while (l1 != null && l2 != null){
            ListNode listNode;
            if (l1.val <= l2.val){
                listNode = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                listNode = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (mergeListHeader == null){
                mergeListHeader = listNode;
            }else{
                mergeListTailer.next = listNode;
            }

            mergeListTailer = listNode;
        }

        if (l1 == null){
            while(l2 != null){
                mergeListTailer.next = l2;
                mergeListTailer = l2;
                l2 = l2.next;
            }
        }

        if (l2 == null){
            while(l1 != null){
                mergeListTailer.next = l1;
                mergeListTailer = l1;
                l1 = l1.next;
            }
        }


        return mergeListHeader;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);

        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;

        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution solution = new Solution();
        ListNode mergeList = solution.mergeTwoLists(listNode,listNode3);
        solution.printList(mergeList);

    }
}