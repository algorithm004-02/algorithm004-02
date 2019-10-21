/** 环形链表 II */

/**
 * 第一种解法 通过Set数据结构判断， 当第一个重复存在的节点为环境的入口节点
 * 复杂度分析 时间复杂度O(n) 空间复杂度O(n)
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
    let cur = head;
    let set = new Set();
    while(cur) {
        if (set.has(cur)) return cur;
        set.add(cur);
        cur = cur.next;
    }
    return null;
};

/**
 * 第二种办法 快慢指针
 * 时间复杂度O(n) 空间复杂度O(1)
 * 数学证明 2(x+n1*c+y)-x+n1*c+y=x+n1*c+y=n2*c，x+y=(n2-n1)*c
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle2 = function(head) {
    let slow = head;
    let fast = head;
    let intersect = null;
    
    while(slow && fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (fast === slow) {
            intersect = fast;
            break;
        }
    }
    
    if (intersect === null) return null;
    
    let pr1 = head;
    let pr2 = intersect;
    
    while(pr1 !== pr2) {
        pr1 = pr1.next;
        pr2 = pr2.next;
    }
    
    return pr1;
};