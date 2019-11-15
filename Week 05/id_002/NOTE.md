# NOTE

 
### DP方程
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
    a. 分治（子问题）a[i] = [Math.max(a[i -1][0], a[i - 1][1]), (a[i - 1][1] + number[i])];
    b. 状态数组： f[i] = [0, 1]； 0：偷， 1：不偷
    c. DP 方程： f[i] = [Math.max(f[i -1][0], f[i - 1][1]), f[i - 1][1] + number[i]];
 
```
