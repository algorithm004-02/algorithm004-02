//递归 
class Solution {
      public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode p = head.next;
        p.next = swapPairs(p.next);
        head.next = p.next;
        p.next = head;
        return p;
    }
}