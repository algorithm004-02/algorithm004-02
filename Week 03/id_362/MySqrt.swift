class Solution {
    func mySqrt(_ x: Int) -> Int {
        var left = 0
        var right = x / 2 + 1
        while left < right {
            let mid = (left + right + 1) / 2
            if mid * mid > x {
                right = mid - 1
            } else {
                left = mid
            }
        }
        return left
    }
}
