## 动态规划的实现及关键点
### 递归代码的模板
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
  recur(level : level+1, newParam);
  // restore current status
```
- 递归终止条件
- 处理当前逻辑
- 递归到下一层
- 恢复当前层状态

### 分治代码模板
```
def divide_conquer(problem, param1, param2, ...) {
  # recursion terminator
  if problem is None
    print_result
    return
  
  # prepare data
  data = prepare_data(problem, data)
  subproblems = split_problem(problem, data)
  
  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0], p1, ...)
  subresult2 = self.divide_conquer(subproblems[1], p1, ...)
  subresult3 = self.divide_conquer(subproblems[2], p1, ...)
  ...
  
  # process and generate the final result
  result = process_result(subresult1, subresult2, subresult3, ...)
  
  # revert the current level states
}
```
重复性，把一个大的问题分解为子问题

感触
1. 人肉递归很累，分解状态树
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维
4. 寻找重复性 -> 计算机的指令集

递归树、状态树

定义：Dynamic Programming
2. simplifying a complicated problem by breaking it down 
  into simpler sub-problems in a recursive manner. 
3. Divide & Conquer + Optional Substructure(最优子结构)

关键点
1. 动态规划 和 递归或分治没有本质的区别（关键看有无最优子结构）
2. 共性：找到重复子问题，存储中间状态 opt[i]
3. 差异性：最优子结构、中途可以淘汰次优解

### DP例题解析：Fibonacci 数列、路径计算
自顶向下，递归
```
int fib (int n, int[] memo) {
  if (n <= 1) return n;
  
  if(memo[n] == 0) {
    memo[n] = fib(n-1) + fib(n-2);
  }
  return memo[n];
}
```
自底向上，Bottom Up,  动态递推
```
a[0]=1, a[1]=1;
for (int i=2; i<=n; ++i) {
  a[i] = a[i-1]+a[i-2];
}
return a[i];
```

Count the paths
```
int countPaths(boolean[][] grid, int row, int col) {
  if (!validSquare(grid, row, col)) return 0;
  if (isAtEnd(grid, row, col)) return 1;
  return countPaths(grid, row+1, col) + countPaths(grid, row, col+1);
}
```
状态转移方程
opt[i, j] = opt[i+1, j] + opt[i, j+1]
if (a[i,j] = '空地'):
  opt[i,j] = opt[i+1, j] + opt[i, j+1]
else:
  opt[i,j] = 0  
```

```
动态规划关键点
1. 最优子结构 opt[n]=best_of(opt[n-1], opt[n-2], ...)
2. 存储中间状态: opt[i]
3. 递推公式（美其名曰：状态转移方程或者 DP 方程）
  Fib: opt[i]=opt[i-1]+opt[i-2]
  二维路径: opt[i,j]=opt[i+1,j]+opt[i,j+1] (且判断a[i,j]是否为空地)