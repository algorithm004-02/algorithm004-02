# 58. [最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word/)

## 题目

给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

==示例:==

```
输入: "Hello World"
输出: 5
```

## 字符串处理

```
class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length() - 1;
        while(length > 0 && s.charAt(length) == ' '){
            length--;
        }

        int wordLength = 0;
        for (int i = 0; i < length+1; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                wordLength = 0;
            }else{
                wordLength ++;
            }
        }
        return wordLength;
    }
}
```


