import UIKit

class SolutionBottomTop {
    // 时间复杂度O(m * n), 空间复杂度O(m * n)
    func uniquePaths(_ m: Int, _ n: Int) -> Int {
        var dp: [[Int]] = [[Int]](repeating: [Int](repeating:1, count: m), count: n)
        for i in (0..<n-1).reversed() {
            for j in (0..<m-1).reversed() {
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
            }
        }
        return dp[0][0]
    }
}

class SolutionTopBottom {
    // m代表列，n代表行，最后[n-1][m-1]为最左下角的格子，就是最终结果。
    // 时间复杂度O(m * n), 空间复杂度O(m * n)
    func uniquePaths(_ m: Int, _ n: Int) -> Int {
        var dp = [[Int]](repeating: [Int](repeating:1, count: m), count: n)
        for i in (1..<n) {
            for j in (1..<m) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }
        return dp[n-1][m-1]
    }
}

class SolutionTopBottomSpaceO2n {
    // 时间复杂度O(m * n), 空间复杂度O(2 * n)
    func uniquePaths(_ m: Int, _ n: Int) -> Int {
        var cur = [Int](repeating: 1, count: m)
        var pre = [Int](repeating: 1, count: m)
        for _ in (1..<n) {
            for j in (1..<m) {
                cur[j] = pre[j] + cur[j-1]
            }
            pre = cur
        }
        return cur[m-1]
    }
}

class SolutionTopBottomSpaceOn {
    func uniquePaths(_ m: Int, _ n: Int) -> Int {
        var cur = [Int](repeating: 1, count: m)
        for _ in (1..<n) {
            for j in (1..<m) {
                cur[j] += cur[j-1]
            }
        }
        return cur[m-1]
    }
}



SolutionTopBottomSpaceOn().uniquePaths(7, 3) // 28
SolutionTopBottomSpaceOn().uniquePaths(4, 4) // 20
