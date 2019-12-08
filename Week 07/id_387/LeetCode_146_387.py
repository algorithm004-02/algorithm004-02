# https://leetcode.com/problems/lru-cache/
# 146. LRU Cache
class LRUCache(object):
  def __init__(self, capacity):
    self.dict = collections.OrderedDict()
    self.remain = capacity

  def get(self, key):
    if key not in self.dict:
      return -1
    v = self.dict.pop(key)
    self.dict[key] = v # key as the newest one
    return v

  def put(self, key, value):
    if key in self.dict:
      self.dict.pop(key)
    else:
      if self.remain > 0:
        self.remain -= 1
      else: # self.dict is full
        self.dict.popitem(last=False)
    self.dict[key] = value