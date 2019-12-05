# https://leetcode-cn.com/problems/relative-sort-array/

class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        result, bucket = [], [0 for _ in range(1001)]
        for i in arr1:
            bucket[i] += 1
        for j in arr2:
            while bucket[j] > 0:
                result.append(j)
                bucket[j] -= 1
        for k in range(len(bucket)):
            while bucket[k] > 0:
                result.append(k)
                bucket[k] -= 1
        return result
