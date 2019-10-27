/** 环形列表 三种解法：1. 暴力解法：500ms; 2. Set数据结构判断， 3.快慢指针 */
/**
 * 暴力解法： 500ms
 * @param {Boolean} hasC 
 */
var hasCycle = function(head) {
    let hasC = false;
    let start = Date.now();
    let cur = head;
    while(cur) {
        if (Date.now() - start > 500) {
            hasC = true;
            break;
        }
        cur = cur.next;
    }
    
    return hasC;
};

/**
 * Set数据结构判断
 * @param {Boolean} 
 */
var hasCycle2 = function(head) {
    let set = new Set();
    let cur = head;
    while(cur) {
        if (!set.has(cur)) {
            set.add(cur);
        } else {
            return true;
        }

        cur = cur.next;
    }
    
    return false;
};

/**
 * 快慢指针
 * @param {Boolean} 
 */
var hasCycle3 = function(head) {
    let slow = head;
    let fast = head;
    
    while(slow && fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow === fast) return true;
    }
    
    return false;
};