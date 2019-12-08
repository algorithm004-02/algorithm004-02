# 191. [位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/)

## 题目

编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

==示例 1：==

```
输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
```

==示例 2：==

```
输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
```

==示例 3：==

```
输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
```

## 循环32次

```
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
```

## %2、/2

```
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int temp = n;
        for (int i = 0; i < 32; i++) {
            if (temp % 2 == 1) {
                count++;
            }
            temp = temp / 2;
        }
        return count;
    }
}
```

## &1、>>

```
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int temp = n;
        for (int i = 0; i < 32; i++) {
            if ((temp & 1) == 1) {
                count++;
            }
            temp = temp >> 1;
        }
        return count;
    }
}
```

## x&(x-1)

> 清除最低位的 0

```
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
```

