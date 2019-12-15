# 

[不同路径2](https://leetcode-cn.com/problems/unique-paths-ii/) 状态转移方程：

```java
if (a[i, j] == 0) {
    dp[i][j] = dp[i+1, j] + dp[i, j+1];
} else {
    // 障碍物
    dp[i][j] = 0;
}
```

# NOTE

## 递归 - 函数自己调用自己

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
    recur(level + 1, newParam);

    // restore current status
}
```


## 分治代码模板

```python
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

## 股票买卖

`dp[i][k][0 or 1]` (0 <= i <= n - 1, 1 <= k <= K)

- i：天数

- k：最多交易次数

- [0, 1]：是否持有股票

总状态数：`n * K * 2`

```python
for 0 <= i < n:
    for 1 <= k <= K
        for s in {0, 1}:
            dp[i][k][s] = max(buy, sell, reset)
```

## Atoi

```java
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(str.length() == 0) return 0;

    //2. Remove Spaces
    while(str.charAt(index) == ' ' && index < str.length())
        index ++;

    //3. Handle signs
    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }
    
    //4. Convert number and avoid overflow
    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        //check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE/10 < total ||            
        	Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
}
```

