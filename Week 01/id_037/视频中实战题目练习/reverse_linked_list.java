// 1 暴力法
// 创建一个新的链表，遍历旧链表元素，从头部插入元素到新链表

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode p = head;
        while (p != null) {
            // 这里需要注意链表指针的丢失，思路是每次用一个临时变量保存当前节点，然后将p更新为下一个节点，防止由于临时节点的更新而丢失链表引用
            ListNode temp = p;
            p = p.next;
            temp.next = newList;
            newList = temp;
        }
        return newList;        
    }
}

//2 手动递归
// 链表为空：head->null, return head
// 链表有一个元素：head->2->null, return head ->2->null
// 链表有两个元素：head->2->1->null
//     p->2->head=null :(head.next.next = head; head == null)
//     1=p->2->head=null
// 所以p指向当前已经反转好的前半部，假设没反转的剩余链表从k开始
// 那么 保存 curr.next, 然后curr.next = p, p=curr

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head.next;
        ListNode p = head;
        head.next = null;
        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = p;
            p = curr;
            curr = tempNode;
        }
        return p;
    }
}

// 3 将以上思路写成递归
class Solution3 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next ==null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}