import java.util.Set;

// https://leetcode-cn.com/problems/linked-list-cycle-ii/
// 1 暴力法
// 时间复杂度O(N)，空间复杂度O(N)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set visited = new HashSet();
        ListNode curr = head;
        int index = 0;
        while (curr != null) {
            if (visited.contains(curr)) {
                return curr;
            }
            visited.add(curr);
            index++;
            curr = curr.next;
        }
        return null;
    }
}
//floyd算法，假设头节点距离环入口有a个节点，环的长度为b个节点
// 1 设置慢指针slow每次向前移动一步，快指针fast每次向前移动两步
// 2 记录快慢指针第一次相遇的节点，那么快慢指针走过的距离有如下关系：distance(f) = distance(s) + nb，其中n是套圈次数。
        // 假设相逢位置在环内h处,在相遇时慢指针绕环c次：那么2(h+a+cb) = h+a+cb+nb,那么h+a = (n-c)b. 既然n和c都是非负整数，那么上面这个式子就表明从头部到入口处的距离a，加上第一次相遇的距离h，正好是整数倍的环长。
// 3 将快指针重置到head，此时快慢指针以同样速度为1向前遍历，那么下一次相遇的地方就是环入口
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }      
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}