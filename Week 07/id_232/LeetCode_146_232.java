package src.main.java.com.fans.algorithm00402.week7.homework;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * LRU缓存机制
 */
class LRUCache {

    private class CacheNode {
        private int val;
        private int key;
        private CacheNode prev;
        private CacheNode next;

        public CacheNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private void addToFirst(CacheNode node) {
        CacheNode next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    private void removeNode(CacheNode node) {
        CacheNode prev = node.prev;
        CacheNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToFirst(CacheNode node) {
        removeNode(node);
        addToFirst(node);
    }

    private CacheNode removeLastNode() {
        if (front.prev == head)
            return null;

        CacheNode node = front.prev;
        removeNode(front.prev);
        return node;
    }

    private CacheNode head;
    private CacheNode front;
    private Map<Integer, CacheNode> map;
    private int capacity;

    public LRUCache(int capacity) {
        head = new CacheNode(-1, -1);
        front = new CacheNode(-1, -1);
        head.next = front;
        front.prev = head;

        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            moveToFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.val = value;
            moveToFirst(node);
        } else {
            if (map.size() == this.capacity) {
                CacheNode node = removeLastNode();
                map.remove(node.key);
            }

            CacheNode node = new CacheNode(key, value);
            addToFirst(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
