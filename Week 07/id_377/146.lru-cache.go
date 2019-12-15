/*
 * @lc app=leetcode id=146 lang=golang
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (27.86%)
 * Likes:    4037
 * Dislikes: 166
 * Total Accepted:    392.1K
 * Total Submissions: 1.4M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */



/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */

 import "container/list"

 // LRUCache contains a hash map and a doubly linked list
 type LRUCache struct {
     cap int                   // capacity
     l   *list.List            // doubly linked list
     m   map[int]*list.Element // hash table for checking if list node exists
 }
 
 // Pair is the value of a list node.
 type Pair struct {
     key   int
     value int
 }
 
 // Constructor initializes a new LRUCache.
 func Constructor(capacity int) LRUCache {
     return LRUCache{
         cap: capacity,
         l:   new(list.List),
         m:   make(map[int]*list.Element, capacity),
     }
 }
 
 // Get a list node from the hash map.
 func (c *LRUCache) Get(key int) int {
     // check if list node exists
     if node, ok := c.m[key]; ok {
         val := node.Value.(*list.Element).Value.(Pair).value
         // move node to front
         c.l.MoveToFront(node)
         return val
     }
     return -1
 }
 
 // Put key and value in the LRUCache
 func (c *LRUCache) Put(key int, value int) {
     // check if list node exists
     if node, ok := c.m[key]; ok {
         // move the node to front
         c.l.MoveToFront(node)
         // update the value of a list node
         node.Value.(*list.Element).Value = Pair{key: key, value: value}
     } else {
         // delete the last list node if the list is full
         if c.l.Len() == c.cap {
             // get the key that we want to delete
             idx := c.l.Back().Value.(*list.Element).Value.(Pair).key
             // delete the node pointer in the hash map by key
             delete(c.m, idx)
             // remove the last list node
             c.l.Remove(c.l.Back())
         }
         // initialize a list node
         node := &list.Element{
             Value: Pair{
                 key:   key,
                 value: value,
             },
         }
         // push the new list node into the list
         ptr := c.l.PushFront(node)
         // save the node pointer in the hash map
         c.m[key] = ptr
     }
 }
 



// Javascript Map, only 1 data structure https://leetcode.com/problems/lru-cache/discuss/266148/Javascript-Map-only-1-data-structure 
//  /**  
//  * @param {number} capacity
//  */
// var LRUCache = function(capacity) {
//     this.m = new Map();
//     this.capacity = capacity;
// };

// /** 
//  * @param {number} key
//  * @return {number}
//  */
// LRUCache.prototype.get = function(key) {
//     if(this.m.has(key))
//     {
//         // Remove and put key/value back into hash to move this key to the back (meaning recently used)
//         var value = this.m.get(key);
//         this.m.delete(key);
//         this.m.set(key,value);
//         return value;
//     }else
//     {
//         return -1;
//     }
// };

// /** 
//  * @param {number} key 
//  * @param {number} value
//  * @return {void}
//  */
// LRUCache.prototype.put = function(key, value) {
//     if(this.m.has(key)) //remove it and add it back with new value
//     {
//         this.m.delete(key);
//         this.m.set(key,value);
//     }else if(this.m.size == this.capacity) //remove the first key (Map adds new keys to the back)
//     {
//         var first_key = this.m.keys().next().value;
//         this.m.delete(first_key);
//         this.m.set(key,value);
//     }else{  //Map has extra capacity
//         this.m.set(key,value);
//     }
// };


// /**
//  * @constructor
//  */
//  var LRUCache = function(capacity) {
//     this.capacity = capacity;
//     this.obj = {};
//     this.arr = [];
//   };
  
//   /**
//    * @param {number} key
//    * @returns {number}
//    */
//   LRUCache.prototype.get = function(key) {
//     var val = this.obj[key];
//     if (val > 0) {
//       var index = this.arr.indexOf(key);
//       this.arr.splice(index, 1);
//       this.arr.unshift(key);
//       return val;
//     } else 
//     return -1;
//   };
  
//   /**
//    * @param {number} key
//    * @param {number} value
//    * @returns {void}
//    */
//   LRUCache.prototype.set = function(key, value) {
  
//     if (this.obj[key]) {
//       this.obj[key] = value;
//       var index = this.arr.indexOf(key);
//       this.arr.splice(index, 1);
//       this.arr.unshift(key);
//       return;
//     }
  
//     if (this.capacity === this.arr.length) {
//       var k = this.arr.pop();
//       this.obj[k] = undefined;
//     }
  
//     this.obj[key] = value;
//     this.arr.unshift(key);
//   };





// @lc code=end

