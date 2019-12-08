#
# @lc app=leetcode id=146 lang=python3
#
# [146] LRU Cache
#

# @lc code=start
import collections

class ListNode:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:

    # def __init__(self, capacity: int):
    #     self.capacity = capacity
    #     self.dict = collections.OrderedDict()
        

    # def get(self, key: int) -> int:
    #     if key not in self.dict:
    #         return -1
    #     v = self.dict.pop(key)
    #     self.dict[key] = v
    #     return v

    # def put(self, key: int, value: int) -> None:
    #     if key in self.dict:
    #         self.dict.pop(key)
    #     else:
    #         if self.capacity > 0:
    #             self.capacity -= 1
    #         else:
    #             self.dict.popitem(last=False)
    #     self.dict[key] = value

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.hashmap = {}
        self.head = ListNode()
        self.tail = ListNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def move_to_tail(self, key: int):
        node = self.hashmap[key]
        node.prev.next = node.next
        node.next.prev = node.prev

        node.prev = self.tail.prev
        node.next = self.tail
        self.tail.prev.next = node
        self.tail.prev = node
    
    def get(self, key: int) -> int:
        if key in self.hashmap:
            self.move_to_tail(key)
            return self.hashmap[key].value
        return -1

    def put(self, key: int, value: int) -> None:
        new_node = ListNode(key, value)
        if key in self.hashmap:
            self.hashmap[key].value = value
            self.move_to_tail(key)
        else:
            if len(self.hashmap) == self.capacity:
                self.hashmap.pop(self.head.next.key)
                self.head.next = self.head.next.next
                self.head.next.prev = self.head
            self.hashmap[key] = new_node
            new_node.prev = self.tail.prev
            new_node.next = self.tail
            self.tail.prev.next = new_node
            self.tail.prev = new_node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end

