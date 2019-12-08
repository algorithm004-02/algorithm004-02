# 77. [组合](https://leetcode-cn.com/problems/combinations/)

## 题目

给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

==示例:==

```
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

## 递归

```
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }
        subCombine(0, k, n, new ArrayList<>(), result);
        return result;
    }

    void subCombine(int level, int max, int num, List<Integer> list, List<List<Integer>> result) {
        if (level == max) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i < num + 1; i++) {
            if (list.size() == 0 || (list.get(list.size() - 1) < i)) {
                list.add(i);
                subCombine(level + 1, max, num, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
```

