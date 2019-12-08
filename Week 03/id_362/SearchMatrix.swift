class Solution {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        let m = matrix.count
        if m == 0 { return false }
        let n = matrix[0].count

        var left = 0
        var right = m * n - 1
        while left < right {
            let mid = (left + right) / 2
            let value = matrix[mid / n][mid % n]
            if target > value {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return matrix[left / n][right % n] == target
    }
}

let matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

assert(Solution().searchMatrix(matrix, 3) == true)
assert(Solution().searchMatrix(matrix, 13) == false)
assert(Solution().searchMatrix([[1], [3], [5]], 5) == true) 

print("SUCCESS!")
