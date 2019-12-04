#
# @lc app=leetcode.cn id=1122 lang=python3
#
# [1122] 数组的相对排序
#

# @lc code=start
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        arr = [0 for _ in range(1001)]
        ans = []
        for i in range(len(arr1)):
            arr[arr1[i]] += 1
        for j in range(len(arr2)):
            while arr[arr2[j]] > 0:
                ans.append(arr2[j])
                arr[arr2[j]] -= 1
        for k in range(len(arr)):
            while arr[k] > 0:
                ans.append(k)
                arr[k] -= 1
        return ans
                
# @lc code=end

