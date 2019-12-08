package app.homeworkWeekSeventh;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (27.83%)
 * Likes:    4035
 * Dislikes: 166
 * Total Accepted:    392K
 * Total Submissions: 1.4M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
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
 * LRUCache cache = new LRUCache(2);
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
class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    
    int capacity;
    int count;
    Map<Integer,DLinkedNode> cache = new LinkedHashMap<>();
    DLinkedNode head;
    DLinkedNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        //从缓存中查询，如果不存在返回-1，
        //存在返回对应的数据，并调整到缓存头部
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            this.moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //如果存在则更新元素，并调整到缓存头部
        //如果不存在则加入到缓存，并校验缓存大小
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.value = value;
            this.moveToHead(node);
        } else {
            DLinkedNode node = new DLinkedNode();
            node.key = key;
            node.value = value;
            this.cache.put(key, node);
            this.addNode(node);
            count ++;
            
            if (count > capacity) {
                this.cache.remove(tail.pre.key);
                this.removeNode(tail.pre);
                count --;
            }
        }
    }

    /**
     * 添加元素到链表头部
     * 
     * @param node
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        head.post.pre = node;
        node.post = head.post;
        head.post = node;
    }

    /**
     * 移除一个元素
     * @param pre
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    /**
     * 调整元素到头部
     * 
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

