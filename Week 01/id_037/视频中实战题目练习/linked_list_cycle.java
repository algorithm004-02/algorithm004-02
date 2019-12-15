import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/linked-list-cycle/
// 暴力法
public class Solution {
    public boolean hasCycle(ListNode head) {
        Map visited = new HashMap();
        while (head != null) {
            if (visited.containsKey(head)) {
                return true;
            }
            visited.put(head, head.val);
            head = head.next;
        }
        return false;
    }
}
// 快慢指针法
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != fast && (fast != null && fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (fast != null && fast.next != null);
    }
}