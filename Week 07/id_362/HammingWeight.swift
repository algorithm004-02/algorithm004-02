class Solution {
    func hammingWeight(_ n: Int) -> Int {
        var bits = 0
        var mask = 1
        for i in 0..<32 {
            if (n & mask) != 0 {
                bits += 1
            }
            mask << 1
        }
        return bits
    }
}

class SolutionII {
    func hammingWeight(_ n: Int) -> Int {
        var count = 0
        var n = n
        while (n != 0) {
            count += 1
            n &= (n - 1)
        }
        return count
    }
}
