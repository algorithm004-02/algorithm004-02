# 创建双向链表
class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        # 构建首尾节点, 使之相连
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

        self.lookup = dict()
        self.max_len = capacity

    def get(self, key: int) -> int:
        if key in self.lookup:
            node = self.lookup[key]
            self.remove(node)
            self.add(node)
            return node.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.lookup:
            self.remove(self.lookup[key])
        if len(self.lookup) == self.max_len:
            # 把表头位置节点删除(说明最近的数据值)
            self.remove(self.head.next)
        self.add(Node(key, value))
    # 删除链表节点
    def remove(self, node):
        del self.lookup[node.key]
        node.prev.next = node.next
        node.next.prev = node.prev
    # 加在链表尾
    def add(self, node):
        self.lookup[node.key] = node
        pre_tail = self.tail.prev
        node.next = self.tail
        self.tail.prev = node
        pre_tail.next = node
        node.prev = pre_tail