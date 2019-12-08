class Solution {
    func isPerfectSquare(_ num: Int) -> Bool {
        var left = 0
        var right = num / 2 + 1
        while left < right {
            let mid = (left + right + 1)  / 2
            let square = mid * mid
            if square > num {
                right = mid - 1
            } else {
                left = mid
            }
        }

        return left * left == num
    }
}

assert(Solution().isPerfectSquare(14) == false)
assert(Solution().isPerfectSquare(4) == true)

