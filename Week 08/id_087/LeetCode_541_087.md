# 541. [反转字符串 II](https://leetcode-cn.com/problems/reverse-string-ii/)

## 题目

给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

==示例:==

```
输入: s = "abcdefg", k = 2
输出: "bacdfeg"
```

## 字符串处理

```
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;) {
            if(i + 2*k < chars.length || i + k < chars.length){
                reverseArray(chars, i, i+k-1);
            }else{
                reverseArray(chars , i, s.length() - 1);
            }
            i = i + 2*k;
        }
        return new String(chars);
    }

    public void reverseArray(char[] array, int start, int end){
        for (int i = start; i < end; i++, end--) {
            char ch = array[i];
            array[i] = array[end];
            array[end] = ch;
        }
    }
}
```


