// https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null && count < k ) {
            curr = curr.next;
            count++;
        }
        if (count == k) { //此时curr指向第k+1个节点
            curr = reverseKGroup(curr, k);
            while (count > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                count--;
            }
            head = curr;
        }
        return head;
    }
}