
// https://leetcode.com/problems/swap-nodes-in-pairs/
// 将链表两两相邻的节点当做一个处理单元unit
//     处理单元的头部地址记录为i，后一个节点记为i
//     处理单元内部，交换节点位置
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prevUnit = null;
        while (curr != null && curr.next != null) {
            ListNode nextUnit = curr.next.next;
            if (prevUnit == null) {
                head = curr.next;
            } else {
                prevUnit.next = curr.next;
            }
            curr.next.next = curr;
            curr.next = nextUnit;
            prevUnit = curr;
            curr = nextUnit;
        }
        return head;
    }
}

// 递归法 (学习答案区所得)

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode p = swapPairs(next.next);
        next.next = head;
        head.next = p;
        return next;
    }
}