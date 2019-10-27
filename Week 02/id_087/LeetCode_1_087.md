# 1. [两数之和](https://leetcode-cn.com/problems/two-sum/description/)

## 题目

给定一个整数数组`nums`和一个目标值 `target`，请你在该数组中找出和为目标值的那`两个`整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

==示例==

```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

## 暴力法，两层循环

> 时间复杂度O(n2)，空间复杂度O(1)

```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
```


## hash

### 两遍哈希

> 时间复杂度为O(n)，空间复杂度为O(n)

```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            // 处理和为同一个数的两遍的情况
            if (map.containsKey(key) && map.get(key) != i) {
                return new int[]{i, map.get(key)};
            }
        }
        return null;
    }
}
```

### 一遍哈希

> 时间复杂度为O(n)，空间复杂度为O(n)

```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
```


