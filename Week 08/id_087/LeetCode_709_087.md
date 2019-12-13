# 709. [转换成小写字母](https://leetcode-cn.com/problems/to-lower-case/)

## 题目

实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

==示例 1：==

```
输入: "Hello"
输出: "hello"
```

==示例 2：==

```
输入: "here"
输出: "here"
```

==示例 3：==

```
输入: "LOVELY"
输出: "lovely"
```

## 字符处理

```
class Solution {
    public String toLowerCase(String str) {
        char[] chars = new char[str.length()];
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            chars[i] = ch;
        }
        return new String(chars);
    }
}
```


