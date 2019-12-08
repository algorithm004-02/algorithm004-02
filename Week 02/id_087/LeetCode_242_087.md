# 242. [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)

## 题目

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

==示例 1:==

```
输入: s = "anagram", t = "nagaram"
输出: true
```

==示例 2:==

```
输入: s = "rat", t = "car"
输出: false
```

## 判断排序后的字符串是否相同

> 时间复杂度为 O(nlogN)，空间复杂度O(1)

```
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}
```

## Hash

> Hash，一个++，一个--，判断最后每个字符是否为0。时间复杂度 O(n)，空间复杂度O(n)


```
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
```

> Hash，一个++，统计每个字母的数量。另外一个循环--，一旦数量小于0，返回 false。时间复杂度 O(n)，空间复杂度O(n)

```
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
```


