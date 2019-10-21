//迭代：构造一个前置结点，依次遍历两个链表进行判断，改变各个结点的头指针，依次连接到前置指针后。
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(-1);
        ListNode preOprNode = preNode;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                preOprNode.next = l1;
                l1 = l1.next;
            } else {
                preOprNode.next = l2;
                l2 = l2.next;
            }
            preOprNode = preOprNode.next;
        }
        preOprNode.next = l1 != null? l1 : l2;
        return preNode.next;
    }
}