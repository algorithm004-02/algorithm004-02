# https://leetcode-cn.com/problems/lru-cache/

class Node:
    def __init__(self, key: int=0, value: int=0):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.cache = {}
        self.capacity = capacity
        self.size = 0
        # 哨兵节点
        self.head = Node()
        self.tail = Node()
        # 头尾指针
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        # key不在cache中 直接返回-1
        node = self.cache.get(key)
        if not node:
            return -1
        # key在cache中 调整位置到头部 返回元素
        self._move_to_head(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        # key在cache中 直接调整位置到头部 更新节点值
        node = self.cache.get(key)
        if node:
            node.value = value
            self._move_to_head(node)
            return
        # key不在cache中 放入cache 并加入头部节点
        node = Node(key, value)
        self.cache[key] = node
        self._add_node(node)
        self.size += 1
        # 如果容量已满 删除尾部元素
        if self.size > self.capacity:
            tail = self._pop_tail()
            del self.cache[tail.key]
            self.size -= 1

    def _move_to_head(self, node: Node):
        self._remove_node(node)
        self._add_node(node)

    def _remove_node(self, node: Node):
        prev, next = node.prev, node.next
        prev.next = next
        next.prev = prev

    def _add_node(self, node: Node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node

    def _pop_tail(self) -> Node:
        node = self.tail.prev
        self._remove_node(node)
        return node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
