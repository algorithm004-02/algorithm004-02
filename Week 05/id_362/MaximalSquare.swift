import Foundation

extension Solution {
    public func maximalSquare(_ matrix: [[Character]]) -> Int {
        if matrix.isEmpty || matrix.first?.isEmpty ?? true { return 0 }
        var result = 0
        let m = matrix.count
        let n = matrix[0].count
        var dp = [[Int]](repeating: [Int](repeating: 0, count: n + 1), count: m + 1)
        for i in 1...m {
            for j in 1...n {
                if matrix[i - 1][j - 1] == "1" {
                    dp[i][j] = min(min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1
                    result = max(result, dp[i][j])
                }
            }
        }
        return result * result
    }
}
