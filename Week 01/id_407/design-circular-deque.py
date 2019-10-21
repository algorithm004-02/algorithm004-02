class MyCircularDeque:

    def __init__(self, k: int):
        self._capacity = k
        self._data = []

    def insertFront(self, value: int) -> bool:
        if len(self._data) == self._capacity:
            return False
        self._data.insert(0, value)
        return True

    def insertLast(self, value: int) -> bool:
        if len(self._data) == self._capacity:
            return False
        self._data.append(value)
        return True

    def deleteFront(self) -> bool:
        if not self._data:
            return False
        self._data.pop(0)
        return True

    def deleteLast(self) -> bool:
        if not self._data:
            return False
        self._data.pop()
        return True

    def getFront(self) -> int:
        return self._data[0] if self._data else -1

    def getRear(self) -> int:
        return self._data[-1] if self._data else -1

    def isEmpty(self) -> bool:
        return len(self._data) == 0

    def isFull(self) -> bool:
        return len(self._data) == self._capacity
