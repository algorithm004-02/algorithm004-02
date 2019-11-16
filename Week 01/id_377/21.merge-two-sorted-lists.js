// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    // ------------------------- 解法1 start --------------------------
    // 最好记  👍 👍 👍 👍 👍
    // 最优解  😘 😘 😘 😘 😘
    if(!l1 || !l2) return (l1? l1:l2);
    if(l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
    
    // ------------------------- 解法1 start --------------------------
    // 最好记  👍 👍 👍
    // 最优解  😘 😘 😘 😘 😘
    // const result = new ListNode(null);
    // let n = result;
    // while (l1 !== null || l2 !== null) {
    //     if (l1 === null) {
    //     n.next = l2;
    //     l2 = l2.next;
    //     } else if (l2 === null) {
    //     n.next = l1;
    //     l1 = l1.next;
    //     } else if (l1.val < l2.val) {
    //     n.next = l1;
    //     l1 = l1.next;
    //     } else {
    //     n.next = l2;
    //     l2 = l2.next;
    //     }
    //     n = n.next;
    // }
    // return result.next;

};
// @lc code=end

