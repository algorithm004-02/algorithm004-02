### 高级动态规划
#### 动态规划的复习
递归 - 函数自己调用自己
```java
public void recur(int level, int param) {
  // terminator
  if (level > MAX_LEVEL) {
    // process result
    return;
  }
  
  // process current logic
  process(level, param);
  
  // drill down
  recur(level:level-1, newParam);
  
  //restore current status
}
```
分治 - 分而治之，可以用递归和不用递归（计算机设计角度、切换成机器思维）

```python
def divide_conquer(problem, param1, param2, ...) {
  # recursion terminator
  if problem is None:
    print_result
    return
  
  # prepare data
  data = prepare_data(problem)
  subproblem = split_problem(problem, data)
  
  # conquer subproblems
  subresult1 = self.divide_conquer(subproblem[0], p1, ...)
  subresult2 = self.divide_conquer(subproblem[1], p2, ...)
  
  # process and generate the final result
  result = process_result(subresult1, subresult2, ...)
  
  # revert the current level states 
}
```

- 人肉递归，低效，累
- 找到最近最简方法，将其拆解成可重复解决的问题，最大公约素
- 数学归纳法思想
- 本质 - 寻找重复性
- 递归状态树、重复子状态

动态规划的要点

- 复杂问题分解为简单子问题
- 分治+最优子结构
- 顺推形式：动态递推
```python
function DP():
  # 二维情况
  dp = [][]
  
  for i=0...M {
    for j=0...N {
      # 之前的递推到现在的递推
      dp[i][j] = _Function(dp[i1][j1]...)
    }
  }
  return dp[M][N];
```
动态规划 和 递归或者分治 没有本质上的区别（关键看有无最优子结构）
拥有共性：找到重复子问题
差异性：最优子结构、中途可以淘汰次优解

常见的 DP 题目和状态方程
##### 爬楼梯问题 f(n) = f(n-1)+f(n-2), f(1)=1 f(0)=0
```python
def f(n):
  if n<=1: return 1
  return f(n-1) + f(n-2)
  
def f(n):
  if n<=1: return 1
  if n not in mem:
    mem[n] = f(n-1)+f(n-2)
  return mem[n]
_______
def f(n):
  dp = [1] * (n+1)
  for i in range(2, n+1)
    dp[i] = dp[i-1] + dp[i-2]
  return dp[i]
  
def f(n):
  x, y = 1, 1
  for i in range(1, n)
    y, x = x+y, y
  return y
```
##### 不同路径问题
f(x,y) = f(x-1,y)+f(x,y-1)
```python
def f(x, y):
  if x <= 0 or y <= 0: return 0
  if x ==1 and y == 1: return 1
  return f(x-1, y) + f(x, y-1)
  
def f(x, y):
  if x <= 0 or y <= 0: return 0
  if x== 1 and y == 1: return 1
  if (x, y) not in mem:
    m[(x,y)] = f(x-1, y) + f(x, y-1)
  return mem[(x,y)]
____________
def f(x, y):
  dp = [[0] * (m+1) for _ in range(n+1)]
  dp[1][1] = 1
  for i in range(1, y+1)
    for j in range(1, x+1)
      dp[i][j] = dp[i-1][j] + dp[i][j-1]
  return dp[]
```
##### 打家劫舍
```python
dp1
dp[i] 状态的定义： max $ of robbing A[0 -> i]
dp[i] = max(dp[i-1], dp[i-2]+nums[i])
dp2
dp[i][0]状态的定义： max $ of robbing A[0 -> i] 且没偷 nums[i]
dp[i][1]状态的定义： max $ of robbing A[0 -> i] 且偷了 nums[i]
dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
dp[i][1] = dp[i-1][0] + nums[i];
```
##### 最小路径和
```python
dp[i][j] 状态的定义： minPaht(A[1 -> i][1 -> j])
dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + A[i][j]
```
#### 股票买卖
```python
dp[i][k][0 or 1] ( 0 <= i <= n-1, 1 <= k <= K)
#i 为天数
#k 为最多交易次数
#[0,1] 为是否持有股票
#总状态数：nK2 种状态

for 0 <= i <= n:
for 1 <= k <= K:
for s in {0, 1}:
dp[i][k][s] = max(buy, sell, rest)

dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
max(选择 rest, 选择 sell)
#解释：今天我没有持有股票，有两种可能

## 昨天没有持有，然后今天选择 rest, 所以我今天还是没有持有
### 昨天持有股票，但是今天 sell, 所以今天没有持有股票了
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
max(选择 rest, 选择 buy)
#解释：今天持有着股票，有两种可能

#昨天就持有股票，今天选择 rest, 所以今天还持有股票
#昨天没有持有股票，但今天选择 buy, 所以今天就持有股票了
#状态转移方程
#初始状态：
dp[-1][k][0] = dp[i][0][0] = 0
dp[-1][k][1] = dp[i][0][1] = -infinity
#状态转移方程：
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
```
#### 进阶版的动态规划
高级 DP 复杂度来源

 - 状态拥有更多维度（二维、三维 或者更多、甚至需要压缩）
 - 状态方程更加复杂
 - 编辑距离
- BFS 双端BFS
- DP
```python
dp[i][j] // word1.substr(0, i) 与 word2.substr(0, j) 之间的编辑距离
edit_dist(i, j) = MIN (edit_dist(i-1, j-1)+1, edit_dist(i-1, j)+1, edit(i, j-1)+1)
如果 word1[i] 与 word2[j] 相同，显然 dp[i][j] = dp[i-1][j-1]
如果 word1[i] 与 word2[j] 不同，那么 dp[i][j] 可以通过
在 dp[i-1][j-1] 基础上做 replace 操作达到目的
在 dp[i-1][j] 的基础上做 insert 操作达到目的
在 dp[i][j-1] 的基础上做 delete 操作达到目的
取三者最小情况即可
```
### 字符串基础知识和引申题目
string is immutable

#### 高级字符串算法
 动态规划 和 字符串 相结合

1. 编辑距离
二维数组
最长公共子序列
```python
dp[i][j] = dp[i-1][j-1]+1(if s1[i-1] == s2[i-1])
else dp[i][j] = max(dp[i-1][j], dp[i][j-1])
最长公共字串
dp[i][j] = dp[i-1][j-1] + 1 (if s1[i-1] == s2[j-1])
else dp[i][j] = 0
```
#### 字符串匹配算法
A 串 和 B 串， 找到出现位置
暴力法 brute force O(m*n)
```python
public static int forceSearch(String txt, String pat) {
  int m = txt.length();
  int n = pat.length();
  
  for (int i=0; i<m-n; i++) {
    int j;
    for (j=0; j<n; j++) {
      if (txt.charAt(i+j) != pat.charAt(j)) {
        break;
      }
    }
    if (j == n) {
      return i;
    }
    // 加速
    // 1. 预先判断，hash(txt.substring) == hash(pat). Rabin-Karp 算法
    // 2. KMP
  }
  return -1;
}
```
