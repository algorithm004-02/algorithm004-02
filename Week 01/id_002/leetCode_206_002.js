/** 第一种利用递归方法 */
/**
 * 核心原理 利用当前函数调用栈中存储存储值 进行翻转。
 * 时间复杂度为O(n), 空间复杂度O(n), 因链表长度为n, 需要n函数栈存储空间
 * @param {*} head 
 */
var reverseList = function(head) {
    if (head === null || head.next === null) return head;
    let p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
};

/**
 *  第二种解法 时间复杂度O(n) 空间复杂度为O(1)
 * @param {*} head 
 */
var reverseList2 = function(head) {
    if (head === null) return head;
    
    let prev = null;
    let cur = head;

    while (true) {
        let next = cur.next;
        cur.next = prev;
        if (next === null) break;

        [prev, cur] = [cur, next];
    }

    return cur;
};