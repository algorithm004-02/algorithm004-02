import Foundation

public class Solution {
    public init() {}
}

extension Solution {
    public func longestCommonSubsequence(_ text1: String, _ text2: String) -> Int {
        if text1.isEmpty || text2.isEmpty { return 0 }
        var dp = [[Int]](repeating: [Int](repeating: 0, count: text2.count + 1), count: text1.count + 1)
        let text1 = Array(text1)
        let text2 = Array(text2)
        for i in 1...text1.count {
            for j in 1...text2.count {
                if text1[i-1] == text2[j-1] {
                    dp[i][j] = dp[i-1][j-1] + 1
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                }
                print(dp)
            }
        }
        return dp[text1.count][text2.count]
    }
}
