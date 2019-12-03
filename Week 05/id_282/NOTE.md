### 动态规划 Dynamic Programming
- [Wiki定义:](https://en.wikipedia.org/wiki/Dynamicprogramming) 
- "Simplifying a complicated problem by breaking it down into simpler subproblems" (in a recursive manner)
-  Divide & Conquer + Optimal substructure 分治+最优子结构
#### 动态规划与分治关键点
- 动态规划 和递归或者分治 没有根本上的区别 (关键看有无最优的子结构)
- 共性: 找到重复子问题
- 差异性: 最优子结构、中途可以淘汰次优解

#### Bottom Up
```python
F[n] = F[n-1] + F[n-2]
a[0] = 0, a[1] = 1;
for(int i=2;i<=n;++i){
    a[i] = a[i-1]+a[i-2];
}
a[n]
0,1,1,2,3,5,8,13
```
#### 动态规划关键点
- 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
- 储存中间状态: opt[i]
- 递推公式 (每日名曰:状态转移方程或者DP方程)
Fib: opt[i]=opt[n-1]+opt[n-2]
二维路径: opt[i,j]=opt[i+1][j]+opt[i][j+1] (且判断a[i,j]是否空地)
#### 字符串问题
```
S1 = ""
S2 = 任意字符串

S1 = "A"
S2 = 任意

S1 = ".....A"
S2 = "....A"
```
**子问题**
```
S1 = "ABAZDC"
S2 = "BACBAD"
```
**DP方程**
```
If S1[-1]!=S2[-1]:LCS[s1,s2]=Max(LCS[s1-1,s2],LCS[s1,s2-1])
IF S1[-1]==S2[-1]:LCS[s1,s2]=LCS[s1-1,s2-1]+1
```
#### 动态规划小结
- 打破自己的思维惯性, 形成机器思维(找重复性)
理解复杂逻辑的关键
也是职业进阶的要点要领
#### DP解法
重复性(分治)
定义状态数组
DP方程