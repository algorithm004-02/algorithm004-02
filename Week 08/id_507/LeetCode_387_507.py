class Solution:
    def firstUniqChar(self, s):
        count = collections.Counter(s)
        index = 0
        for ch in s:
            if count[ch] == 1:
                return index
            else:
                index += 1
        return -1
