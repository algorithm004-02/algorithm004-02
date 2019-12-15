# 学习笔记

## 动态规划、状态转移方程串讲

### 递归模板复习

```
public void recur(int level, int param) {
 // terminator
 if (level > MAX_LEVEL) {
 // process result
 return;
 }
 // process current logic
 process(level, param);
 // drill down
 recur(level: level + 1, newParam);
 // restore current status

}
```

### 分治代码模板复习

```
def divide_conquer(problem, param1, param2, ...):
# recursion terminator
if problem is None:
 print_result
 return
# prepare data
 data = prepare_data(problem)
 subproblems = split_problem(problem, data)
# conquer subproblems
 subresult1 = self.divide_conquer(subproblems[0], p1, ...)
 subresult2 = self.divide_conquer(subproblems[1], p1, ...)
 subresult3 = self.divide_conquer(subproblems[2], p1, ...)
…
# process and generate the final result
 result = process_result(subresult1, subresult2, subresult3, …)

 # revert the current level states
```

### 动态规划要点复习

1. 将复杂问题分解成简单子问题。
2. Divide & Conquer + Optimal substructure，即分治 + 最优子结构
3. 顺推形式： 动态递推

### 动态规划地推模板复习

```
function DP():
 dp = [][] # ⼆维情况
 for i = 0 .. M {
 for j = 0 .. N {
 dp[i][j] = _Function(dp[i’][j’]…)
 }
 }
 return dp[M][N];
```

### 动态规划和递归、分治的异同点

1. 共同点：找到重复子问题
2. 差异点：最优子结构、中途可以淘汰次优解

## 字符串基础知识

### 可变与不可变字符串比较

原文：

1. In Java, C#, JavaScript, Python and Go, strings are immutable. Furthermore, Java, C#, JavaScript and Go have the notion of a constant: a “variable” that cannot be reassigned. (I am unsure how well constants are implemented and supported in JavaScript, however.)
2. In Ruby and PHP, strings are mutable.
   The C language does not really have string objects per se. However, we commonly represent strings as a pointer char \*. In general, C strings are mutable. The C++ language has its own string class. It is mutable.In both C and C++, string constants (declared with the const qualifier) are immutable, but you can easily “cast away” the const qualifier, so the immutability is weakly enforced.
3. In Swift, strings are mutable.However, if you declare a string to be a constant (keyword let), then it is immutable.

翻译：

1. 在 Java，C＃，JavaScript，Python 和 Go 中，字符串是不可变的。此外，Java，C＃，JavaScript 和 Go 具有常量的概念：无法重新分配的“变量”。（不过，我不确定常量在 JavaScript 中实现和支持的程度如何。）

2. 在 Ruby 和 PHP 中，字符串是可变的。
   C 语言本身实际上没有字符串对象。但是，我们通常将字符串表示为指针 char \*。通常，C 字符串是可变的。C ++语言具有自己的字符串类。这是可变的。
   在 C 和 C ++中，字符串常量（用 const 限定符声明）都是不可变的，但是您可以轻松地“舍弃” const 限定符，因此对弱性的强制性很弱。

3. 在 Swift 中，字符串是可变的。
   但是，如果您将字符串声明为常量（关键字 let），则它是不可变的。

[https://lemire.me/blog/2017/07/07/are-your-strings-immutable/](https://lemire.me/blog/2017/07/07/are-your-strings-immutable/)

## 字符串匹配算法

1. 暴力法（brute force） - O(mn)
   字符串匹配暴力法代码示例：[https://shimo.im/docs/dQDxQW8yXPXxh3Hg/read](https://shimo.im/docs/dQDxQW8yXPXxh3Hg/read)

2. Rabin-Karp 算法
   Rabin-Karp 代码示例：[https://shimo.im/docs/KXDdkT99TVtXvTXP/read](https://shimo.im/docs/KXDdkT99TVtXvTXP/read)

3. KMP 算法
   字符串匹配的 KMP 算法：[http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)
   KMP 字符串匹配算法 1：[https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171](https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171)
   KMP 字符串匹配算法 2：[https://www.bilibili.com/video/av16828557/?spm_id_from=333.788.videocard.0](https://www.bilibili.com/video/av16828557/?spm_id_from=333.788.videocard.0)

4. Boyer-Moore 算法
   字符串匹配的 Boyer-Moore 算法：[https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html](https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html)

5. Sunday 算法
   字符串匹配之 KMP、BoyerMoore、Sunday 算法：[https://blog.csdn.net/u012505432/article/details/52210975](https://blog.csdn.net/u012505432/article/details/52210975)

# 同学代码、总结 Review

1. [https://github.com/algorithm004-02/algorithm004-02/issues/1253#issuecomment-562912168](https://github.com/algorithm004-02/algorithm004-02/issues/1253#issuecomment-562912168)
2. [https://github.com/algorithm004-02/algorithm004-02/issues/1246#issuecomment-562912253](https://github.com/algorithm004-02/algorithm004-02/issues/1246#issuecomment-562912253)
3. [https://github.com/algorithm004-02/algorithm004-02/issues/1244#issuecomment-562912643](https://github.com/algorithm004-02/algorithm004-02/issues/1244#issuecomment-562912643)
4. [https://github.com/algorithm004-02/algorithm004-02/issues/1243#issuecomment-562912674](https://github.com/algorithm004-02/algorithm004-02/issues/1243#issuecomment-562912674)
5. [https://github.com/algorithm004-02/algorithm004-02/issues/1238#issuecomment-562912953](https://github.com/algorithm004-02/algorithm004-02/issues/1238#issuecomment-562912953)
