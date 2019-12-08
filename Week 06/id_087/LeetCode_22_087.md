# 22. [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

## 题目

给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

## 分治/剪枝

```
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, "", n, result);
        return result;
    }
    
    public void generate(int left, int right, String str, int max, List<String> result) {
        if(right == max) {
            result.add(str);
            return;
        }
        if(left < max) generate(left + 1, right, str + "(", max, result);
        if(right < left) generate(left, right + 1, str + ")", max, result);
    }
}
```


