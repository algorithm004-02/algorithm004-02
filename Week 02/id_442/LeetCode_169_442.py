# https://leetcode-cn.com/problems/majority-element/solution/

# 暴力法
# time complexity: O(N^2)
# space complexity: O(1)
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums) // 2
        for num in nums:
            count = sum(1 for i in nums if i == num)
            if count > n:
                return num

# 排序法
# time complexity: O(NlogN)
# space complexity: O(1)或O(N)
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums)//2]

# 哈希表法
# time complexity: O(N)
# space complexity: O(N)
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        data = {}
        for num in nums:
            data[num] = data[num] + 1 if num in data else 1
        return max(data.keys(), key=data.get)
