# NOTE

 
### DP方程
- [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/description/)
```
    1. 暴力
    2. DP：
        a. 分治（子问题) 
            problem(i, j) = Min(sub(i + 1, j), sub(i + 1, j + 1)) + a[i, j]
        b. 状态数组定义 f[i, j]
        c. DP方程 
            f(i, j) = Min(f(i + 1, j), f(i + 1, j + 1)) + a[i, j]
```

- [53.最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)
 ```
     1. 暴力
     2. DP：
         a. 分治（子问题） max_sum(i) = Max(max_sub(i - 1), 0) + a[i]
         b. 状态数组定义   f[i]
         c. DP方程        f[i] = Max(f[i - 1], 0) + a[i]
```

- [152.乘积最大子序列](https://leetcode-cn.com/problems/maximum-product-subarray/submissions/)
 ```
     1. 暴力
     2. DP：
         a. 分治（子问题)
             res = [number[i], number[i] * a[i - 1][0], number[i] * a[i - 1][1]]
             a[i] = [Min(res), Max(res)]
         b. 状态数组定义 f[i] = [minVal, maxVal]
         c. DP方程 
              res = [number[i], number[i] * f[i - 1][0], number[i] * f[i - 1][1]]
              f[i] = [Min(res), Max(res)]
```

- [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)
```
  1. 暴力
  2. BFS
  3. DP
        a. 分治（子问题）
        b. 状态数组定义: f(n) = min(f(n - k), for(k in [1,2,5])) + 1
        c. DP方程
 ```

- [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)
```
  DP:
    a. 分治（子问题）a[i] = [a[i - 1][1] + number[i], Max(a[i -1][0], a[i - 1][1])];
    b. 状态数组： f[i] = [0, 1]； 0：偷， 1：不偷
    c. DP 方程： f[i] = [f[i - 1][1] + number[i], Math.max(f[i -1][0], f[i - 1][1])];
```
* [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)
* [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
* [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)
* [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)

```
DP:（122 不考虑交易次数）
    a. 重复子问题
        max_profrit[i][0] = Max(max_profrit[i - 1][1] + prices[i], max_profrit[i - 1][0])
        max_profrit[i][1] = Max(max_profrit[i - 1][0] - prices[i], max_profrit[i - 1][1])
    b. 定义状态数组
        f[i] = [0, 1]
        0：代表不持有股票
        1: 代表持有股票
    c. DP方程
        f[i][0] = Max(f[i - 1][1] + prices[i], f[i - 1][0])
        f[i][1] = Max(f[i - 1][0] - prices[i], f[i - 1][1])

DP:(1次交易)
    a. 重复子问题
        max_profrit[i][0] = Max(max_profrit[i - 1][1] + prices[i], max_profrit[i - 1][0])
        max_profrit[i][1] = Max(- prices[i], max_profrit[i - 1][1])
    b. 定义状态数组
        f[i] = [0, 1]
            0 : 不持有股票
            1 : 持有股票
    c. DP方程
        f[i][0] = Max(f[i - 1][1] + prices[i], f[i - 1][0])
        f[i][1] = Max(- prices[i], f[i - 1][1])

DP: (123 最多2笔交易)
    a. 重复子问题
        maxPro[i][0][0] = maxPro[i - 1][0][0]
        maxPro[i][0][1] = Math.max(maxPro[i - 1][0][1], maxPro[i - 1][0][0] - prices[i])

        maxPro[i][1][0] = Math.max(maxPro[i - 1][1][0], maxPro[i - 1][0][1] + prices[i])
        maxPro[i][1][1] = Math.max(maxPro[i - 1][1][1], maxPro[i - 1][1][0] - prices[i])

        maxPro[i][2][0] = Math.max(maxPro[i - 1][2][0], maxPro[i - 1][1][1] + prices[i])
    b. 定义状态数组
        f[i][k][j]
            i: 第几天
            k: 
                0： 0次交易
                1： 第一次交易
                2： 第二次交易
            j: 
                0: 没有持有股票
                1： 持有股票
    c. DP方程
        f[i][0][0] = f[i - 1][0][0]
        f[i][0][1] = Max(f[i - 1][0][1], f[i - 1][0][0] - prices[i])

        f[i][1][0] = Max(f[i - 1][1][0], f[i - 1][0][1] + prices[i])
        f[i][1][1] = Max(f[i - 1][1][1], f[i - 1][1][0] - prices[i])

        f[i][2][0] = Max(f[i - 1][2][0], f[i - 1][1][1] + prices[i])


DP: (188 最多k笔交易)
    a. 重复子问题
        for k range(K) :
            k === 0
            maxPro[i][0][0] = maxPro[i - 1][0][0]
            maxPro[i][0][1] = Math.max(maxPro[i - 1][0][1], maxPro[i - 1][0][0] - prices[i])
            k > 0
            maxPro[i][k][0] = Math.max(maxPro[i - 1][k][0], maxPro[i - 1][k - 1][1] + prices[i])
            maxPro[i][k][1] = Math.max(maxPro[i - 1][k][1], maxPro[i - 1][k][0] - prices[i])

    b. 定义状态数组
        f[i][k][j]
            i: 第几天
            k: 
                0： 0次交易
                1： 第一次交易
                2： 第二次交易
            j: 
                0: 没有持有股票
                1： 持有股票
    c. DP方程
        for k Range(k) :
            k === 0
            f[i][0][0] = f[i - 1][0][0]
            f[i][0][1] = Max(f[i - 1][0][1], f[i - 1][0][0] - prices[i])

            k > 0
            f[i][k][0] = Max(f[i - 1][k][0], f[i - 1][k - 1][1] + prices[i])
            f[i][k][1] = Max(f[i - 1][k][1], f[i - 1][k][0] - prices[i])
```
- [32.最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/submissions/)
```
我们用 dp[i] 表示以 i 结尾的最长有效括号；
当 s[i] 为 (,dp[i] 必然等于 0，因为不可能组成有效的括号；
那么 s[i] 为 )
2.1 当 s[i-1] 为 (，那么 dp[i] = dp[i-2] + 2；
2.2 当 s[i-1] 为 ) 并且 s[i-dp[i-1] - 1] 为 (，那么 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]；....()) dp[i - 1]前一个字符 '('
2.2 注意边界问题 dp[i - 2] 与 dp[i - dp[i - 1] - 2] 越界问题
DP:
    a. 重复子问题
        dp[i] = dp[i - 2] + 2 || dp[i-1] + 2 + dp[i-dp[i-1]-2]      
    b. 定义状态数组
        fn[i]
    c. DP方程
        f[i] = dp[i - 2] + 2 || dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
```
