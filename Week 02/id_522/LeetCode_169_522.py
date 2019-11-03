import collections
class Solution:
    def majorityElement(self, nums):
        counts = collections.Counter(nums)

        #print(counts.get(3))
        #print(counts.keys())

        return max(counts.keys(), key=counts.get)
