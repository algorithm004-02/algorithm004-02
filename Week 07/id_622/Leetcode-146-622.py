"""
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

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

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class LRUCache(object):
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.dict = collections.OrderedDict()
        self.capacity = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.dict:
            return -1
        result = self.dict.pop(key)
        self.dict[key] = result
        return result
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key not in self.dict:
            if self.capacity > 0:
                self.capacity -= 1
            else:
                self.dict.popitem(last = False)
        else:
            self.dict.pop(key)
        self.dict[key] = value
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

class DlinkedNode():
    def __init__(self):
        self.key = 0
        self.value = 0
        self.prev = None
        self.next = None
        
        
class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.cache = {}
        self.size = 0
        self.capacity = capacity
        self.head = DlinkedNode()
        self.tail = DlinkedNode()
        
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        node = self.cache.get(key, None) # get if not exist return None
        if not node:
            return -1
        
        # if exist move node to head
        self._move_node_to_head(node)
        return node.value
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        node = self.cache.get(key, None)
        if not node:
            new_node = DlinkedNode()
            new_node.key = key
            new_node.value = value
            
            self.cache[key] = new_node
            self._add_node(new_node)
            
            self.size += 1
            if self.size > self.capacity:
                tail = self._pop_tail()
                del self.cache[tail.key]
                self.size -= 1
        else:
            node.value = value
            self._move_node_to_head(node)
        
    def _move_node_to_head(self, node):
        self._remove_node(node)
        self._add_node(node)
        
    def _remove_node(self, node):
        # node.prev <-> node <-> node.next
        node_prev = node.prev
        node_next = node.next
        
        node_prev.next = node_next
        node_next.prev = node_prev
    
    def _add_node(self, node):
        # add new node to head
        # head.next <-> first_node <-> second_node
        # After: head.next <-> node <-> first_node
        #head_next = self.head.next
        #self.head.next = node
        #node.prev = self.head
        
        #node.next = head_next
        #head_next.prev = node
        
        # 分步解决，先解决新的Node的前后单向的问题
        node.prev = self.head
        node.next = self.head.next
        
        # 再解决双向的问题
        self.head.next.prev = node
        self.head.next = node
        
    def _pop_tail(self):
        res = self.tail.prev
        self._remove_node(res)
        return res
        

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)