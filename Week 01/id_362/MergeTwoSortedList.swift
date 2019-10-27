/* #21 合并有序列表

   将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
       输入：1->2->4, 1->3->4
       输出：1->1->2->3->4->4

   https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */

/// 使用递归
/// - Complexity: O(m + n) m表示l1的长度，n表示l2的长度。
class SolutionRecursion {
    func mergeTwoList(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        // 基准情况：l1为空的话返回l2
        if l1 == nil {
            return l2
        } else if l2 == nil {
            return l1
        } 

        // 递归地将两个链表合并
        // 如果l1的值小于等于l2的值，将l1的后继指向l1头节点元素后面的元素与l2合并的结果，并将l1返回
        // 如果l2的值大于l1的值，将l2的后继指向l2头节点元素后面的元素与l1合并的结果，并将l2返回
        if l1!.val <= l2!.val {
            l1?.next = mergeTwoList(l1?.next, l2)
            return l1
        } else {
            l2?.next = mergeTwoList(l1, l2?.next)
            return l2
        }
    }
}

/// 使用迭代
/// - Complexity: O(m + n) m表示l1的长度，n表示l2的长度
class SolutionIterate {
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var dummy: ListNode? = ListNode(-1)
        var cur = dummy
        var l1 = l1
        var l2 = l2
        // 两个链表都不为空时，比较两个节点的值
        while l1 != nil && l2 != nil {
            if l1!.val <= l2!.val {
                cur?.next = l1
                cur = cur?.next
                l1 = l1?.next
            } else {
                cur?.next = l2
                cur = cur?.next
                l2 = l2?.next
            }
        }
        // 当某个链表为空时跳出循环，并将cur指向不为空的链表
        if (l1 == nil) {
            cur?.next = l2
        } else {
            cur?.next = l1
        }
        // 返回头节点
        return dummy?.next
    }
}
