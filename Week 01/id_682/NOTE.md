# NOTE

## 心得：
    1. 清晰空间换时间。
	1. 强化下双指针使用(同一题多做几遍，多思考几遍)
		

## 疑惑：
leetcode题目第26道(删除排序数组中的重复项)

python跑了下，举例为 [1,1,2,1], 按照要求，新长度是2，但是代码跑出来了3，但是leetcode也是通过的，有点不解

```
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        newLen =  1
        
        if len(nums) == 0:
            return 0
        
        for i in range(1, len(nums)) :
            if nums[i] != nums[i-1]:
                nums[newLen] = nums[i]
                newLen += 1
        return newLen

if __name__ == "__main__":
    solution = Solution()
    
    nums = [1,1,2,1]
    newLen = solution.removeDuplicates(nums)
    print(newLen)
```