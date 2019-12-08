/**
 228. 比特位计数
 最直观的解法便是 计算 0...n 中的每个数中二进制1的个数，然后加入到数组中
 */
class Solution {
    func countBits(_ num: Int) -> [Int] {
        return (0...num).map { num in
            var count = 0
            var n = num
            while n != 0 {
                count += 1
                n &= (n - 1)
            }
            return count
        }
    }
}
