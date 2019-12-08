/** 146. LRU缓存机制  **/

// 1. Map 存储的有序性实现LRU cache(Least Recently Used)
// 2. hashMap + 双向链表 实现

/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.map = new Map();
    this.capacity = capacity;
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if (!this.map.has(key)) return -1;    

    let val = this.map.get(key);
    this.map.delete(key);
    this.map.set(key, val);

    return val;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if (this.map.has(key)) {
        this.map.delete(key); 
    } else {
        if (this.capacity > 0) {
            this.capacity -= 1;
        } else {
            let keyIterator = this.map.keys();
            this.map.delete(keyIterator.next().value);
        }
    }

    this.map.set(key, value);
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */


 /**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity;
    this.hashMap = {};

    // 初始化两个哨兵节点 head 和 tail 并 head <--> tail
    this.head = new ListNode();
    this.tail = new ListNode();
    this.head.next = this.tail;
    this.tail.prev = this.head;
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    let node = this.hashMap[key];
    if (!node) return - 1;   

    this._moveNode2Tail(node);

    return node.val;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    let node = this.hashMap[key];   

    
    if (node) {
        node.val = value;
        this._moveNode2Tail(node);
        return ;
    }

    if (this.capacity > 0) {
        this.capacity -= 1;
    } else {
        let first = this.head.next;
        delete this.hashMap[first.key];

        this.head.next = first.next;
        first.next.prev = this.head;
        first.next = null;
        first.prev = null;
        firtst = null;
    }

    // prev <---> newNode <---> tail  hashmap[key] = newNode
    let newNode = new ListNode(key, value);
    this.hashMap[key] = newNode;

    
    newNode.next = this.tail;
    newNode.prev = this.tail.prev;

    this.tail.prev.next = newNode;
    this.tail.prev = newNode;
};

/**
 * @param {ListNode} node
 */
LRUCache.prototype._moveNode2Tail = function (node) {

    // node.prev <---> node.next 进行链接 
    node.prev.next = node.next;
    node.next.prev = node.prev;

    let tail = this.tail;

    // tail.prev <--- node ---> tail
    node.prev = tail.prev;
    node.next = tail;

    // tail.prev ---> node <--- tail
    tail.prev.next = node;
    tail.prev = node;
}
/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */


function ListNode(key, val) {
    this.key = key;
    this.val = val;
    
    this.prev = null;
    this.next = null;
}