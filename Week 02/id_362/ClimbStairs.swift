class SolutionDumbRecursion {
  func climbStairs(_ n: Int) -> Int  {
    if n == 1 { return 1 }
    if n == 2 { return 2 }
    return climbStairs(n - 1) + climbStairs(n - 2)
  }
}

/// 傻递归，模拟真实情况
class SolutionDumbRecursionV2 {
  func climbStairs(_ n: Int) -> Int {
    return _climbStairs(0, n)
  }

  /// 递归求解
  ///
  /// 基准情况为：1. 当前的级数大于目标台阶数，不能再上了，所以返回0。2. ？
  /// 模拟真实上楼的情况，所以从current出发，每次只能上一级(current + 1) 或者上两级(current+2)
  ///
  /// - Parameters: 
  ///   - current: 当前在第几层
  ///   - target: 要上第几层
  private func _climbStairs(_ current: Int, _ target: Int) -> Int {
    if current > target {
      return 0
    }
    if current == target {
      return 1
    }
    
    return _climbStairs(current + 1, target) + _climbStairs(current + 2, target)
  }
}

/// 带缓存的递归解法
/// 使用一个数组缓存计算过的结果
class SolutionWithMemo {
  private var memo: [Int?] = []

  func climbStairs(_ n: Int) -> Int {
    memo = [Int?](repeating: nil, count: n)
    return _climbStairs(0, n)
  }

  private func _climbStairs(_ i: Int, _ n: Int) -> Int {
    if i > n { return 0 }
    if i == n { return 1 }
    if let res = memo[i] { return res }
    let res = _climbStairs(i + 1, n) + _climbStairs(i + 2, n)
    memo[i] = res
    return res
  }
}

class SolutionRecursionWithCache {
  private var cache: [Int: Int] = [:]
  func climbStairs(_ n: Int) -> Int {
    if n == 1 {
      dict[1] = 1
      return 1
    }
    if n == 2 {
      dict[2] = 2
      return 2
    }
    let a: Int
    if let i = cache[n - 1] {
      a = i
    } else {
      a = climbStairs(n - 1)
      cache[n - 1] = a
    }

    let b: Int
    if let i = cache[n - 2] {
      b = i 
    } else {
      b = climbStairs(n - 2)
      cache[n - 2] = b
    }

    return a + b
  }
}

/// 动态规划
class SolutionDP {
  func climbStairs(_ n: Int) -> Int {
    if n == 1 || n == 2 { return n }
    var dp: [Int] = [Int](repeating: 0, count: n + 1)
    dp[1] = 1
    dp[2] = 2
    var i = 3
    while i <= n { 
      dp[i] = dp[i - 1] + dp[i - 2]
      i += 1
    }
    return dp[n]
  }
}