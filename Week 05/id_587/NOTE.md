# 学习笔记

## 动态规划的实现及关键点

分治、回溯、递归、动态规划在实现上很相似。

### 分治回顾

重点是把大问题分解为可重复的几个子问题，在递归中分别进行解决。

其中需要熟练运用数学归纳法思维，切忌人肉递归。

### 动态规划

1. 维基百科对动态规划的定义：

[https://en.wikipedia.org/wiki/Dynamic_programming](https://en.wikipedia.org/wiki/Dynamic_programming)

关键点：
Simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner.
将一个复杂问题，分解成简单子问题，用递归方式解决。

2. 动态规划与分治的思想相似，其区别在于动态规划问题一般需要求一个最优解，如最大值等，即存在最优子结构。

实际应用过程中，通常不需要保存所有中间状态，而只需要保存每次计算的最优状态。当然我们同时也需要证明，中间每一步的最优，会导致全局最优。

因此在开发过程中，每一步都需要缓存结果，通常可以用数组，同时每一步只缓存最优结果。

### 动态规划关键点

1. 动态规划和递归或分治没有根本上的区别，关键是动态规划通常有最优子结构。
2. 动态规划和递归或分治的共性是需要找到重复子问题。
3. 动态规划和递归或分治的差异是，动态规划有最优子结构，中途需要淘汰次优解。

## 学习体会

动态规划的思想不难理解，但在解决实际问题时，往往不容易找到解决方案，即使有思路，通过代码实现也存在一定困难。

特别是解答出错时，很难搞清楚是解题思路有问题，还是实现细节有问题，也没有想到什么特别好的调试方法，基本处于一出错就

# 同学代码、总结 Review

1. [https://github.com/algorithm004-02/algorithm004-02/issues/799#issuecomment-554737989](https://github.com/algorithm004-02/algorithm004-02/issues/799#issuecomment-554737989)
2. [https://github.com/algorithm004-02/algorithm004-02/issues/794#issuecomment-554738658](https://github.com/algorithm004-02/algorithm004-02/issues/794#issuecomment-554738658)
3. [https://github.com/algorithm004-02/algorithm004-02/issues/791#issuecomment-554738832](https://github.com/algorithm004-02/algorithm004-02/issues/791#issuecomment-554738832)
4. [https://github.com/algorithm004-02/algorithm004-02/issues/787#issuecomment-554738901](https://github.com/algorithm004-02/algorithm004-02/issues/787#issuecomment-554738901)
5. [https://github.com/algorithm004-02/algorithm004-02/issues/779#issuecomment-554739453](https://github.com/algorithm004-02/algorithm004-02/issues/779#issuecomment-554739453)

特别收藏 182 同学的笔记，有空自己也推导一遍思路。
[https://github.com/algorithm004-02/algorithm004-02/issues/779](https://github.com/algorithm004-02/algorithm004-02/issues/779)
