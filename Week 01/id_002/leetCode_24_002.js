/** 递归方式进行调换 */

/**
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {*} head 
 */
var swapPairs = function(head) {
    if (head === null || head.next === null) return head;
    
    let next = head.next;
    head.next = swapPairs(next.next);
    next.next = head;
    
    return next;
};
/**
 * 时间复杂度O(n) 空间复杂度O(1)
 */
var swapPairs2 = function(head) {
    let self = {next: head};
    let prev = self;
    
    while(prev.next && prev.next.next) {
        let a = prev.next;
        let b = prev.next.next;
        
        [prev.next, b.next, a.next] = [b, a, b.next];
        
        prev = a;
    }
    
    return self.next;
};